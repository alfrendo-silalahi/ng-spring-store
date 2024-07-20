package dev.alfrendosilalahi.project.repository;

import dev.alfrendosilalahi.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
