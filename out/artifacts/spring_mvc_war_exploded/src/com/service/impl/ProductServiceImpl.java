package com.service.impl;

import com.dao.entity.Product;
import com.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by CS on 2017/6/23.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private Map<Long, Product> products = new HashMap<>();
    private AtomicLong generator = new AtomicLong();

    public ProductServiceImpl() {
        Product product = new Product();
        product.setName("Spring mvc");
        product.setDescription("good book!");
        product.setPrice(999.99F);
        this.add(product);
    }

    @Override
    public Product add(Product product) {
        long newID = generator.incrementAndGet();
        product.setId(newID);
        products.put(newID, product);
        return product;
    }

    @Override
    public Product get(long id) {
        return products.get(id);
    }
}
