package com.josewer.product.repository;

import com.josewer.product.entity.Category;
import com.josewer.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product ,Long> {

    public List<Product> findByCategory(Category category);
}
