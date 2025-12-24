package com.example.products.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseDTO {

    private UUID id;
    private String name;
    private Double price;
    private Integer quantity;
    private LocalDateTime createdAt;
}
