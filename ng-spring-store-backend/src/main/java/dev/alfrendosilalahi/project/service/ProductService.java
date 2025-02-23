package dev.alfrendosilalahi.project.service;

import dev.alfrendosilalahi.project.dto.request.ProductRequestDto;
import dev.alfrendosilalahi.project.dto.response.ProductResponseDto;
import dev.alfrendosilalahi.project.enums.SortDirEnum;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> getProducts(int page, int size, String sortBy, SortDirEnum sortDirEnum, Long categoryId);

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto getProduct(Long id);

}
