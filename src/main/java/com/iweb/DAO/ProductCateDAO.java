package com.iweb.DAO;

import com.iweb.bean.ProductCate;

import java.util.List;

/**
 * @author jxy
 * @date
 */
public interface ProductCateDAO {
    boolean add(ProductCate productCate);
    boolean update(ProductCate productCate);
    boolean deleteProduct(String pid);
    List<ProductCate> list(String cid);
    ProductCate get(String pid);
}
