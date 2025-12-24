package com.example.products.controller;

import com.example.products.dto.request.ProductRequestDTO;
import com.example.products.dto.response.ProductResponseDTO;
import com.example.products.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAllProducts(){
        return ResponseEntity
                .ok(productService.findAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findProductById(@PathVariable UUID id){
        return ResponseEntity
                .ok(productService.findProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO productDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.createProduct(productDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> editProductById(@PathVariable UUID id,
                                                              @Valid @RequestBody ProductRequestDTO productDTO){
        return ResponseEntity
                .ok(productService.editProductById(id, productDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable UUID id){
        productService.deleteProductById(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}