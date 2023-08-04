package com.iweb.service.impl;

import com.iweb.DAO.CategoryDAO;
import com.iweb.DAO.impl.CategoryDAOImpl;
import com.iweb.bean.Category;
import com.iweb.service.CategoryService;
import com.iweb.util.UUIDUtil;

import java.util.List;

/**
 * @author jxy
 * @date
 */
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public List<Category> list(int pageIndex,int pageSize) {
        return categoryDAO.list(pageIndex,pageSize);
    }

    @Override
    public int count() {
        return categoryDAO.count();
    }

    @Override
    public boolean add(Category category) {
        boolean isExist = categoryDAO.verifyName(category.getName());
        if(isExist){
            return false;
        }else {
            category.setId(UUIDUtil.uuid());
            return categoryDAO.add(category);
        }
    }

    @Override
    public boolean delete(String id) {
        return categoryDAO.delete(id);
    }

    @Override
    public Category get(String id) {
        return categoryDAO.get(id);
    }

    @Override
    public List<Category> queryAllCategory() {
        return categoryDAO.queryAllCategory();
    }

    @Override
    public List<Category> list() {
        return categoryDAO.list();
    }

}
