package dev.alfrendosilalahi.project.repository;

import dev.alfrendosilalahi.project.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
