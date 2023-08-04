package com.iweb.service;

import com.iweb.bean.ProductCate;

/**
 * @author jxy
 * @date
 */
public interface ProductCateService {
    boolean add(ProductCate productCate);
    boolean moveToOtherCategory(String categoryId);
    boolean deleteProduct(String pid);
    boolean update(ProductCate productCate);
    ProductCate get(String pid);
}
