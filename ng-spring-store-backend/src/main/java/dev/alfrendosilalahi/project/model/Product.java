package dev.alfrendosilalahi.project.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;

    private String name;

    private String description;

    private Double unitPrice;

    private String imageUrl;

    private boolean active;

    private Integer unitsInStock;

    private LocalDateTime dateCreated;

    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;

}
