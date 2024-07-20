package dev.alfrendosilalahi.project.service;

import dev.alfrendosilalahi.project.dto.request.ProductRequestDto;
import dev.alfrendosilalahi.project.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> getProducts();

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto getProduct(Long id);

}
