package com.bitbox.app.service;

import com.bitbox.app.dao.ProductDao;
import com.bitbox.app.exception.ProductException;
import com.bitbox.app.model.ProductMinimized;
import com.bitbox.app.model.entity.PriceReduction;
import com.bitbox.app.model.entity.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    ProductDao productDao;

    @InjectMocks
    ProductServiceImpl productServiceImpl;

    private static Product mockProduct;
    private static Optional<Product> mockOptionalProduct;
    private static Optional<Product> mockOptionalEmpty;

    @BeforeClass
    public static void setData() {

        mockProduct = new Product();

        mockOptionalProduct = Optional.of(new Product());
        mockOptionalEmpty = Optional.empty();
    }

    @After
    public void resetData() {
        mockProduct = new Product();
    }

    @Test
    public void testFindAll() throws Exception {

        List<ProductMinimized> mockProductMinimizedList = Collections.singletonList(new ProductMinimized());
        when(productDao.findAll()).thenReturn(mockProductMinimizedList);

        List<ProductMinimized> result = productServiceImpl.findAll();
        List<ProductMinimized> expected = mockProductMinimizedList;

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testFindById() throws Exception {

        when(productDao.findById(anyLong())).thenReturn(mockOptionalProduct);

        Product result = productServiceImpl.findById(0L);
        Product expected = mockOptionalProduct.get();

        Assert.assertEquals(expected, result);
    }

    @Test(expected = ProductException.ProductNotFound.class)
    public void testFindById_throwsProductIdNotFound() throws Exception {

        when(productDao.findById(anyLong())).thenReturn(mockOptionalEmpty);
        Product result = productServiceImpl.findById(0L);

    }

    @Test
    public void testSave() throws Exception {

        when(productDao.save(any(Product.class))).thenReturn(mockProduct);
        when(productDao.existsById(anyLong())).thenReturn(false);

        ProductMinimized productMinimized = new ProductMinimized();
        productMinimized.setId(1L);

        Product result = this.productServiceImpl.save(productMinimized);
        Product expected = mockProduct;

        Assert.assertEquals(result, expected);

    }

    @Test(expected = ProductException.ProductIdNotUnique.class)
    public void testSave_throwsProductIdNotUnique() throws Exception {

        ProductMinimized productMinimized = new ProductMinimized();
        productMinimized.setId(0L);

        when(productDao.existsById(anyLong())).thenReturn(true);
        this.productServiceImpl.save(productMinimized);

    }


    @Test
    public void testUpdate() throws Exception {

        when(productDao.findById(0L)).thenReturn(mockOptionalProduct);
        when(productDao.save(any(Product.class))).thenReturn(mockProduct);

        ProductMinimized productMinimized = new ProductMinimized();
        productMinimized.setId(0L);

        Product result = productServiceImpl.update(0L, productMinimized);
        Product expected = mockProduct;

        Assert.assertEquals(result, expected);
    }


    @Test(expected = ProductException.ProductNotFound.class)
    public void testUpdate_throwsProductIdNotFound() throws Exception {

        when(productDao.findById(anyLong())).thenReturn(Optional.empty());
        productServiceImpl.update(anyLong(), new ProductMinimized());

    }

    @Test(expected = ProductException.ProductIsNotActive.class)
    public void testUpdate_throwsProductIsNotActive() throws Exception {

        mockProduct.setState(false);
        mockProduct.setId(0L);
        when(productDao.findById(anyLong())).thenReturn(Optional.of(mockProduct));

        productServiceImpl.update(0L, new ProductMinimized());
    }

    @Test(expected = ProductException.ProductIdCannotBeModified.class)
    public void testUpdate_throwsProductIdCannotBeModified() throws Exception {

        mockProduct.setId(0L);
        when(productDao.findById(anyLong())).thenReturn(Optional.of(mockProduct));

        ProductMinimized productMinimized = new ProductMinimized();
        productMinimized.setId(1L);

        productServiceImpl.update(0L, productMinimized);

    }

    @Test
    public void testInsertPriceReduction() throws Exception {

        when(productDao.findById(anyLong())).thenReturn(mockOptionalProduct);

        PriceReduction priceReduction = new PriceReduction();
        mockProduct.getPriceReductions().add(priceReduction);
        when(productDao.save(any(Product.class))).thenReturn(mockProduct);

        Product result = productServiceImpl.insertPriceReduction(0L, new PriceReduction());
        Product expected = new Product();
        expected.setPriceReductions(Collections.singletonList(new PriceReduction()));

        Assert.assertEquals(result.getPriceReductions().size(), expected.getPriceReductions().size());
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme