package dev.alfrendosilalahi.project.dto.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRequestDto {

    private Long categoryId;

    private String sku;

    private String name;

    private String description;

    private Double unitPrice;

    private Integer unitsInStock;

}
