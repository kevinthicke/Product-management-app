package com.bitbox.app.service;

import com.bitbox.app.dao.ProductDao;
import com.bitbox.app.exception.ProductException;
import com.bitbox.app.model.ProductMinimized;
import com.bitbox.app.model.entity.PriceReduction;
import com.bitbox.app.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductMinimized> findAll() {
        return this.productDao.findAll();
    }

    @Override
    public Product findById(long id) {
        return this.productDao
                .findById(id)
                .orElseThrow(() -> new ProductException.ProductNotFound(id));
    }

    @Override
    public Product save(ProductMinimized productMinimized) {

        long productId = productMinimized.getId();
        if (productDao.existsById(productId)) {
            throw new ProductException.ProductIdNotUnique(productId);
        }

        return productDao.save(this.buildProduct(productMinimized));
    }

    @Override
    public Product update(long productId, ProductMinimized productMinimized) {

        Product product = productDao
                .findById(productId)
                .orElseThrow(() -> new ProductException.ProductNotFound(productId));
        checkIfProductIsActive(product);
        checkIfProductIdIsNotModified(productId, productMinimized);

        return productDao.save(buildProduct(productMinimized));

    }

    @Override
    public Product insertPriceReduction(long productId, PriceReduction priceReduction) {
        Product product = productDao
                .findById(productId)
                .orElseThrow(() -> new ProductException.ProductNotFound(productId));
        checkIfProductIsActive(product);

        product.getPriceReductions().add(priceReduction);
        return this.productDao.save(product);
    }

    private Product buildProduct(ProductMinimized productMinimized) {

        Product product = new Product();
        product.setId(productMinimized.getId());
        product.setDescription(productMinimized.getDescription());
        product.setPrice(productMinimized.getPrice());
        product.setCreatedAt(new Date());

        return product;
    }

    private void checkIfProductIsActive(Product product) {
        if (!product.isState()) {
            throw new ProductException.ProductIsNotActive(product.getId());
        }
    }

    private void checkIfProductIdIsNotModified(long productId, ProductMinimized productMinimized) {
        if (productId != productMinimized.getId()) {
            throw new ProductException.ProductIdCannotBeModified();
        }
    }

}
