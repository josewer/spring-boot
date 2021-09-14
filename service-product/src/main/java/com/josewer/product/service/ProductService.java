package com.josewer.product.service;

import com.josewer.product.entity.Category;
import com.josewer.product.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> listAllProduct();
    public Product getProduct(Long id);

    public Product ceateProduct (Product product);
    public Product updateProduct(Product product);
    public Product delete (Long id);
    public List<Product> findByCategory(Category category);
    public Product updateStock(Long id , Double quantity);

}
