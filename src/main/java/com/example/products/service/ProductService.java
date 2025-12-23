package com.example.products.service;

import com.example.products.entities.Product;
import com.example.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(Long id){
        return productRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product editProductById(Long id, Product newProduct){
        Product product = productRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        product.setQuantity(newProduct.getQuantity());

        return productRepository.save(product);
    }

    public void deleteProductById(Long id){
        productRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        productRepository.deleteById(id);
    }
}
