package com.example.products.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequestDTO {

    private String name;
    private Double price;
    private Integer quantity;
}
