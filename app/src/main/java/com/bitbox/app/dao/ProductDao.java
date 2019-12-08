package com.bitbox.app.dao;

import com.bitbox.app.model.ProductMinimized;
import com.bitbox.app.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    public Boolean existsById(long productId);
    public Optional<Product> findById(long productId);
    public List<ProductMinimized> findAll();
    public Product save(Product product);
}
