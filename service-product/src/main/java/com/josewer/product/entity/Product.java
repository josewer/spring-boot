package com.josewer.product.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "PRODUCT")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Double stock;
    private String status;


    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
