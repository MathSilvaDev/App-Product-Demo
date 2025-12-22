package com.example.products.controller;

import com.example.products.entities.Product;
import com.example.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productRepository.save(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(){
        return ResponseEntity
                .ok(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id){
        return ResponseEntity
                .ok(productRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProductById(@PathVariable Long id,
                                                   @RequestBody Product newProduct){

        Product product = productRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        product.setQuantity(newProduct.getQuantity());

        return ResponseEntity
                .ok(productRepository.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id){
        productRepository.findById(id).orElseThrow(RuntimeException::new);

        productRepository.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
