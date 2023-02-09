package com.example.E29Product.repository;

import com.example.E29Product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> deleteById(long id);


    List<ProductEntity> findByUserid(Long id);
}
