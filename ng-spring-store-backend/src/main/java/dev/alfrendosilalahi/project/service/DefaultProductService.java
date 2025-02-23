package dev.alfrendosilalahi.project.service;

import dev.alfrendosilalahi.project.dto.request.ProductRequestDto;
import dev.alfrendosilalahi.project.dto.response.ProductResponseDto;
import dev.alfrendosilalahi.project.enums.SortDirEnum;
import dev.alfrendosilalahi.project.exeption.EntityNotFoundException;
import dev.alfrendosilalahi.project.mapper.ProductMapper;
import dev.alfrendosilalahi.project.model.Product;
import dev.alfrendosilalahi.project.model.ProductCategory;
import dev.alfrendosilalahi.project.repository.ProductCategoryRepository;
import dev.alfrendosilalahi.project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductResponseDto> getProducts(int page, int size, String sortBy, SortDirEnum sortDirEnum, Long categoryId) {
        if (page < 1) {
            throw new RuntimeException("page number must be greater than zero");
        }

        Sort sort = sortDirEnum.name().equals(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page - 1, size, sort);

        Page<Product> productPage;

        if (Objects.nonNull(categoryId)) {
            ProductCategory productCategory = productCategoryRepository.findById(categoryId)
                    .orElseThrow(() -> new EntityNotFoundException("product category", "id", categoryId.toString()));
            productPage = productRepository.findAllByProductCategory(productCategory, pageable);
        } else {
            productPage = productRepository.findAll(pageable);
        }

        return productPage.getContent()
                .stream()
                .map(ProductMapper::mapProductToProductResponseDto)
                .toList();
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        ProductCategory productCategory = productCategoryRepository.findById(productRequestDto.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("productCategory", "id", productRequestDto.getCategoryId().toString()));
        Product product = ProductMapper.mapProductRequestDtoToProduct(productRequestDto);
        product.setProductCategory(productCategory);
        Product newProduct = productRepository.save(product);
        return ProductMapper.mapProductToProductResponseDto(newProduct);
    }

    @Override
    public ProductResponseDto getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("product", "id", id.toString()));
        return ProductMapper.mapProductToProductResponseDto(product);
    }

}
