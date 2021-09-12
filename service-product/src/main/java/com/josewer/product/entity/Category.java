package com.josewer.product.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
@Data
@Builder @AllArgsConstructor @NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
