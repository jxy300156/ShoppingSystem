package com.iweb.DAO.impl;

import com.iweb.DAO.CategoryDAO;
import com.iweb.bean.Category;
import com.iweb.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author jxy
 * @date
 */
public class CategoryDAOImpl implements CategoryDAO {
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());
    @Override
    public List<Category> list(int pageIndex,int pageSize) {
        List<Category> categoryList = null;
        int a = pageIndex * pageSize;
        String sql = "Select * from category";
        try {
            sql = sql + " limit " + a + "," + pageSize;
            categoryList = qr.query(sql,new BeanListHandler<>(Category.class));
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int count() {
        String sql = "select count(*) from category";
        try {
            Number number = (Number) qr.query(sql,new ScalarHandler<>());
            return number.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean add(Category category) {
        String sql = "insert into category values(?,?)";
        try{
            int count = qr.update(sql,category.getId(),category.getName());
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "delete from category where id = ?";
        try{
            int count = qr.update(sql,id);
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Category get(String id) {
        Category c = null;
        String sql = "select * from category where id = ?";
        try{
            c = qr.query(sql,new BeanHandler<>(Category.class),id);
            return c;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public boolean verifyName(String name) {
        String sql = "select count(*) from category where name = ?";
        try{
            Number number = (Number)qr.query(sql,new ScalarHandler<>(),name);
            return number.intValue()>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Category> list() {
        String sql = "select * from category";
        try{
            List<Category> categories = qr.query(sql,new BeanListHandler<>(Category.class));
            return categories;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> queryAllCategory() {
        String sql = "select * from category";
        try {
            List<Category> categories =
                    qr.query(sql, new BeanListHandler<>(Category.class));
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
