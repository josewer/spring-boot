package com.josewer.product;

import com.josewer.product.entity.Category;
import com.josewer.product.entity.Product;
import com.josewer.product.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {
    
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory (){
        Product product01 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("descripcion")
                .status("Creado")
                .stock(10d)
                .price(124.99d)
                .createAt(new Date()).build();

        productRepository.save(product01);
        List<Product> productList = productRepository.findByCategory(product01.getCategory());
        Assertions.assertThat(productList.size()).isEqualTo(3);
    }
}
