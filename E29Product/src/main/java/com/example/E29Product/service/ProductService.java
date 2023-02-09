package com.example.E29Product.service;

import com.example.E29Product.entity.ProductEntity;
import com.example.E29Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RestTemplate restTemplate;

    public ProductEntity addProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }
    public ResponseEntity<ProductEntity> getProduct(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isPresent()){
            return ResponseEntity.ok(product.get());
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<List<ProductEntity>> getOrderedProducts(Long id) {
        try {
            ResponseEntity<Long[]> productIds = restTemplate.getForEntity("http://localhost:8082/orderapi/getorders/user/" + id.class);

            return ResponseEntity.ok(productRepository.findAllById(List.of(productIds.getBody())));
        } catch (HttpClientErrorException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<ProductEntity>> getSellerProduct(Long id) {
        List<ProductEntity> products = productRepository.findByUserid(id);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(products);
        }
    }

    public ResponseEntity<ProductEntity> deleteProductById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.ok(product.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ProductEntity> updateProduct(ProductEntity productEntity) {
        if (productRepository.findById(productEntity.getId()).isPresent()) {
            return ResponseEntity.ok(productRepository.save(productEntity));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }


}
