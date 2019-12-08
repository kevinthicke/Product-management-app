package com.bitbox.app.service;

import com.bitbox.app.model.ProductMinimized;
import com.bitbox.app.model.entity.PriceReduction;
import com.bitbox.app.model.entity.Product;

import java.util.List;

public interface ProductService {
    public List<ProductMinimized> findAll();
    public Product findById(long id);
    public Product save(ProductMinimized productMinimized);
    public Product update(long productId, ProductMinimized productMinimized);
    public Product insertPriceReduction(long productId, PriceReduction priceReduction);
}
