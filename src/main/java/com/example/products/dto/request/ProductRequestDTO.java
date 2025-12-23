package com.example.products.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequestDTO {

    @NotBlank
    @Size(max = 15)
    private String name;

    @NotNull
    @PositiveOrZero
    private Double price;

    @NotNull
    @PositiveOrZero
    private Integer quantity;
}
