package com.example.E29Product.restController;

import com.example.E29Product.entity.ProductEntity;
import com.example.E29Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productapi")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping(path = "/addproduct")
    public ProductEntity addProduct( ProductEntity product){
        return productService.addProduct(product);
        //return  productDTO;
    }

//    @PostMapping(path="/viewproduct/{id}")
//    public List<ProductEntity> viewProducts(@PathVariable long id){
//        return productService.viewProducts(id);
//    }

    @DeleteMapping(path="/delete/{id}")
    public ProductEntity deleteProductById(@PathVariable long id){
        return productService.deleteProductById(id);
    }

    public ProductEntity getProduct(long id) {
        return productService.getProduct(id);
    }

    public ProductEntity updateProduct(ProductEntity productEntity) {
        return productService.updateProduct(productEntity);
    }
}
