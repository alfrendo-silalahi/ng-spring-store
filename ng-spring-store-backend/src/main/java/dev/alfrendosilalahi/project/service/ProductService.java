package dev.alfrendosilalahi.project.service;

import dev.alfrendosilalahi.project.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> getProducts();

}
