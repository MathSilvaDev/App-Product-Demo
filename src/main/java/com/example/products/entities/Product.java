package com.example.products.entities;

import com.example.products.dto.request.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 15, nullable = false)
    private String name;

    private Double price;
    
    private Integer quantity;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Product(String name, Double price, Integer quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void update(ProductRequestDTO dto){
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.quantity = dto.getQuantity();
    }
}
