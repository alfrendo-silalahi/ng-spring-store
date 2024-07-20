package dev.alfrendosilalahi.project.mapper;

import dev.alfrendosilalahi.project.dto.request.ProductRequestDto;
import dev.alfrendosilalahi.project.dto.response.ProductResponseDto;
import dev.alfrendosilalahi.project.model.Product;

public class ProductMapper {

    public static ProductResponseDto mapProductToProductResponseDto(Product product) {
        return ProductResponseDto.builder()
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
                .build();
    }

    public static Product mapProductRequestDtoToProduct(ProductRequestDto productRequestDto) {
        return Product.builder()
                .sku(productRequestDto.getSku())
                .name(productRequestDto.getName())
                .description(productRequestDto.getDescription())
                .unitPrice(productRequestDto.getUnitPrice())
                .unitsInStock(productRequestDto.getUnitsInStock())
                .build();
    }

}
