package com.josewer.product;

import com.josewer.product.entity.Category;
import com.josewer.product.entity.Product;
import com.josewer.product.repository.ProductRepository;
import com.josewer.product.service.ProductService;
import com.josewer.product.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {


    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setUp () {
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product computer = Product.builder()
                .id(1L)
                .name("Ordenador")
                .category(Category.builder().id(1L).build())
                .price(12.5d)
                .stock(5d)
                .build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));

        Mockito.when(productRepository.save(computer)).thenReturn(computer);
    }

    @Test
    public void whenValidGetId () {
        Product product = productService.getProduct(1L);
        Assertions.assertThat(product.getName()).isEqualTo("Ordenador");
    }


    @Test
    public void whenValidUpdateStock() {
        Product product = productService.updateStock(1L , 3d);
        Assertions.assertThat(product.getStock()).isEqualTo(3d);
    }


}
