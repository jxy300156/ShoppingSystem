package com.iweb.service.impl;

import com.iweb.DAO.ProductDAO;
import com.iweb.DAO.impl.ProductDAOImpl;
import com.iweb.bean.Product;
import com.iweb.service.ProductService;
import com.iweb.util.UUIDUtil;

import java.util.List;

/**
 * @author jxy
 * @date
 */
public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();
    @Override
    public List<Product> list(int pageIndex, int pageSize) {
        return productDAO.list(pageIndex,pageSize);
    }

    @Override
    public int count() {
        return productDAO.count();
    }

    @Override
    public boolean add(Product product) {
        boolean isExist = productDAO.verifyName(product.getName());
        if(isExist){
            return false;
        }else {
            product.setId(UUIDUtil.uuid());
            return productDAO.add(product);
        }
    }

    @Override
    public boolean delete(String id) {
        return productDAO.delete(id);
    }

    @Override
    public boolean update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public Product accurateGet(String id)  {
        return productDAO.accurateGet(id);
    }

    @Override
    public List<Product> obscureGet(String context) {
        return productDAO.obscureGet(context);
    }

    @Override
    public Product queryById(String id) {
        return productDAO.queryById(id);
    }

    @Override
    public List<Product> listAll() {
        return productDAO.listAll();
    }

    @Override
    public List<Product> list(String cid) {
        return productDAO.list(cid);
    }
}
