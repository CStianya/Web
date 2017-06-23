package com.service;

import com.dao.entity.Product;

/**
 * Created by CS on 2017/6/23.
 */
public interface ProductService {

    Product add(Product product);

    Product get(long id);
}
