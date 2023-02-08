package com.example.E29Product.service;

import com.example.E29Product.entity.ProductEntity;
import com.example.E29Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductEntity addProduct(ProductEntity productEntity) {


        return productRepository.save(productEntity);
    }
//    public List<ProductEntity> viewProducts(long id){
//        List<ProductEntity> products=productRepository.findAll();
//        List<OrderEntity> userOrders = userRepository.getReferenceById(id).getOrders();
//        //request to order
//        for (OrderEntity order:userOrders
//        ) {
//            products.remove(order.getProductEntity());
//        }
//        return products;
//    }


    public ProductEntity deleteProductById(long id){
        return productRepository.deleteById(id);
    }

    public ProductEntity getProduct(long id) {
        return productRepository.getReferenceById(id);
    }

    public ProductEntity updateProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }
}
