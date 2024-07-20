package dev.alfrendosilalahi.project.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductResponseDto {
    
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

}
