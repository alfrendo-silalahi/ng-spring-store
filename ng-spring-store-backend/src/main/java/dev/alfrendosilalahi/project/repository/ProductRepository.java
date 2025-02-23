package dev.alfrendosilalahi.project.repository;

import dev.alfrendosilalahi.project.model.Product;
import dev.alfrendosilalahi.project.model.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByProductCategory(ProductCategory productCategory, Pageable pageable);

}
