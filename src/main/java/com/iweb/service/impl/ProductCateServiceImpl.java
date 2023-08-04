package com.iweb.service.impl;

import com.iweb.DAO.ProductCateDAO;
import com.iweb.DAO.impl.ProductCateDAOImpl;
import com.iweb.bean.ProductCate;
import com.iweb.service.ProductCateService;
import com.iweb.util.UUIDUtil;

import java.util.List;

/**
 * @author jxy
 * @date
 */
public class ProductCateServiceImpl implements ProductCateService {
    private ProductCateDAO productCateDAO = new ProductCateDAOImpl();

    @Override
    public boolean add(ProductCate productCate) {
        return productCateDAO.add(productCate);
    }

    @Override
    public boolean moveToOtherCategory(String categoryId) {
        try {
            List<ProductCate> ps = productCateDAO.list(categoryId);
            String otherCategoryId = "00fc569fc2604d82a9e74c68bcc48f9b";
            for (ProductCate p : ps) {
                p.setCategoryId(otherCategoryId);
                productCateDAO.update(p);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ProductCate productCate) {
        return productCateDAO.update(productCate);
    }

    @Override
    public boolean deleteProduct(String pid) {
        return productCateDAO.deleteProduct(pid);
    }

    @Override
    public ProductCate get(String pid) {
        return productCateDAO.get(pid);
    }
}
