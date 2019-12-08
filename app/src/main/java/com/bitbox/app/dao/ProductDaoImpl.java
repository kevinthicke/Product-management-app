package com.bitbox.app.dao;

import com.bitbox.app.model.ProductMinimized;
import com.bitbox.app.model.entity.Product;
import com.bitbox.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Boolean existsById(long productId) {
        return this.productRepository.existsById(productId);
    }

    @Override
    public Optional<Product> findById(long productId) {
        return this.productRepository.findById(productId);
    }

    @Override
    public List<ProductMinimized> findAll() {
        return this.productRepository
                .findAll()
                .stream()
                .map(this::adaptToProductMinimized)
                .collect(Collectors.toList());
    }

    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    private ProductMinimized adaptToProductMinimized(Product product) {
        ProductMinimized productMinimized = new ProductMinimized();

        productMinimized.setId(product.getId());
        productMinimized.setDescription(product.getDescription());
        productMinimized.setCreatedAt(product.getCreatedAt());
        productMinimized.setPrice(product.getPrice());
        productMinimized.setState(product.isState());

        return productMinimized;
    }
}
