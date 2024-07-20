package dev.alfrendosilalahi.project.service;

import dev.alfrendosilalahi.project.dto.request.ProductRequestDto;
import dev.alfrendosilalahi.project.dto.response.ProductResponseDto;
import dev.alfrendosilalahi.project.exeption.EntityNotFoundException;
import dev.alfrendosilalahi.project.mapper.ProductMapper;
import dev.alfrendosilalahi.project.model.Product;
import dev.alfrendosilalahi.project.model.ProductCategory;
import dev.alfrendosilalahi.project.repository.ProductCategoryRepository;
import dev.alfrendosilalahi.project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductResponseDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::mapProductToProductResponseDto)
                .toList();
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        ProductCategory productCategory = productCategoryRepository.findById(productRequestDto.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "productCategory",
                        "id",
                        productRequestDto.getCategoryId().toString()
                ));
        Product product = ProductMapper.mapProductRequestDtoToProduct(productRequestDto);
        product.setProductCategory(productCategory);
        Product newProduct = productRepository.save(product);
        return ProductMapper.mapProductToProductResponseDto(newProduct);
    }

    @Override
    public ProductResponseDto getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "product",
                        "id",
                        id.toString()
                ));
        return ProductMapper.mapProductToProductResponseDto(product);
    }

}
