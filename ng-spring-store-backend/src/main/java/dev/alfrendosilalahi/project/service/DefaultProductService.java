package dev.alfrendosilalahi.project.service;

import dev.alfrendosilalahi.project.dto.response.ProductResponseDto;
import dev.alfrendosilalahi.project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponseDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> ProductResponseDto.builder()
                        .id(product.getId())
                        .sku(product.getSku())
                        .name(product.getName())
                        .description(product.getDescription())
                        .unitPrice(product.getUnitPrice())
                        .imageUrl(product.getImageUrl())
                        .active(product.isActive())
                        .unitsInStock(product.getUnitsInStock())
                        .dateCreated(product.getDateCreated())
                        .lastUpdated(product.getLastUpdated())
                        .build())
                .toList();
    }

}
