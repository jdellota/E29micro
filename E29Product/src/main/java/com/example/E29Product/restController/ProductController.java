package com.example.E29Product.restController;

import com.example.E29Product.entity.ProductEntity;
import com.example.E29Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/addproduct")
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return productService.addProduct(product);
        //return  productDTO;
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping(path = "/get/{id}")
    public ResponseEntity<ProductEntity> getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @GetMapping(path = "/get/products/ordered/{id}")
    public ResponseEntity<List<ProductEntity>> getOrderedProducts(@PathVariable Long id) {
        return productService.getOrderedProducts(id);
    }


    @GetMapping(path = "/get/seller/{id}")
    public ResponseEntity<List<ProductEntity>> getSellerProduct(@PathVariable Long id) {
        return productService.getSellerProduct(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ProductEntity> deleteProductById(@PathVariable Long id) {
        return productService.deleteProductById(id);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity productEntity) {
        return productService.updateProduct(productEntity);
    }
}
