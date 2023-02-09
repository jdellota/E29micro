package com.example.E29Order.repository;

import com.example.E29Order.entity.OrderEntity;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query("select o from OrderEntity o where o.userid = ?1 and o.productid = ?2")
    Optional<OrderEntity> findByUseridAndProductid(Long userid, Long productid);
    List<OrderEntity> findByUserid(Long userid);

}
