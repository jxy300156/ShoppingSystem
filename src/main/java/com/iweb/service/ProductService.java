package com.iweb.service;

import com.iweb.bean.Product;

import java.util.List;

/**
 * @author jxy
 * @date
 */
public interface ProductService {
    List<Product> list(int pageIndex, int pageSize);
    List<Product> listAll();
    int count();
    boolean add(Product product);
    boolean delete(String id);
    boolean update(Product product);
    Product accurateGet(String id);
    List<Product> obscureGet(String context);
    Product queryById(String id);
    List<Product> list(String cid);
}
