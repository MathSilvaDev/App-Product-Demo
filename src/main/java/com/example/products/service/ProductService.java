package com.example.products.service;

import com.example.products.dto.request.ProductRequestDTO;
import com.example.products.dto.response.ProductResponseDTO;
import com.example.products.entities.Product;
import com.example.products.exception.NotFindByIdException;
import com.example.products.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //GET ALL
    public List<ProductResponseDTO> findAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    //GET BY ID
    public ProductResponseDTO findProductById(UUID id){
        Product product = getProductById(id);
        return toResponseDTO(product);
    }

    //POST
    public ProductResponseDTO createProduct(ProductRequestDTO dto){
        Product product = new Product(
                dto.getName(),
                dto.getPrice(),
                dto.getQuantity()
        );

        productRepository.save(product);
        return toResponseDTO(product);
    }

    //PUT
    @Transactional
    public ProductResponseDTO editProductById(UUID id, ProductRequestDTO dto){
        Product product = getProductById(id);
        product.update(dto);

        return toResponseDTO(product);
    }

    //DELETE
    public void deleteProductById(UUID id){
        getProductById(id);
        productRepository.deleteById(id);
    }

    //ADDITIONAL METHODS
    private Product getProductById(UUID id) {
        return productRepository
                .findById(id)
                .orElseThrow(NotFindByIdException::new);
    }

    private ProductResponseDTO toResponseDTO(Product product){
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getCreatedAt()
        );
    }
}
