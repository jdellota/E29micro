package com.example.E29Product.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Float price;
//    @ManyToOne
//    @JoinColumn(name = "userid", referencedColumnName = "userid")
//    private UserEntity userEntity;
//    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
//    private List<OrderEntity> orders;
    @Column(name = "userid")
    private Long userid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}