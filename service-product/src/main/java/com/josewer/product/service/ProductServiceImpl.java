package com.josewer.product.service;

import com.josewer.product.entity.Category;
import com.josewer.product.entity.Product;
import com.josewer.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product ceateProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreateAt(new Date());

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDB = getProduct(product.getId());

        if (productDB == null) { return null; }

        productDB.setName(product.getName());
        productDB.setCreateAt(product.getCreateAt());
        productDB.setStatus("UPDATED");
        productDB.setCategory(product.getCategory());
        productDB.setDescription(product.getDescription());
        productDB.setPrice(product.getPrice());
        productDB.setStock(product.getStock());

        return productRepository.save(productDB);
    }

    @Override
    public Product delete(Long id) {
        Product productDB = getProduct(id);
        if (productDB == null) { return null; }

        productDB.setStatus("DELETED");

        return productRepository.save(productDB);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {

        Product productDB = getProduct(id);

        if (productDB == null) { return null; }

        productDB.setStock(quantity);

        return productRepository.save(productDB);
    }
}
