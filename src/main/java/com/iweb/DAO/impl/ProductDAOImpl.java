package com.iweb.DAO.impl;

import com.iweb.DAO.ProductDAO;
import com.iweb.bean.Product;
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
public class ProductDAOImpl implements ProductDAO {
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());
    @Override
    public List<Product> list(int pageIndex,int pageSize) {
        List<Product> products = null;
        int a = pageIndex * pageSize;
        String sql = "select * from product";
        try{
            sql = sql + " limit " + a + "," + pageSize;
            products = qr.query(sql,new BeanListHandler<>(Product.class));
            return products;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> listAll() {
        String sql = "select * from product";
        try{
            List<Product> products = qr.query(sql,new BeanListHandler<>(Product.class));
            return products;
        }catch (SQLException e){
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
    public boolean add(Product product) {
        String sql = "insert into product values(?,?,?,?)";
        try{
            int count = qr.update(sql,product.getId(),product.getName(),product.getPrice(),product.getStock());
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "delete from product where id = ?";
        try{
            int count = qr.update(sql,id);
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        String sql = "update product set `name` = ?,price = ?,stock = ? where id = ?";
        try{
            int count = qr.update(sql,product.getName(),product.getPrice(),product.getStock(),product.getId());
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product accurateGet(String id) {
        Product p = null;
        String sql = "select * from product where id = ?";
        try{
            p = qr.query(sql,new BeanHandler<>(Product.class),id);
            return p;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Product> obscureGet(String context) {
        String sql = "select * from product where name like ?";
        String searchContext = context + "%";
        try{
            List<Product> products = qr.query(sql,new BeanListHandler<>(Product.class),searchContext);
            return products;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean verifyName(String name) {
        String sql = "select count(*) from product where name = ?";
        try{
            Number number = (Number)qr.query(sql,new ScalarHandler<>(),name);
            return number.intValue()>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public Product queryById(String id) {
        String sql = "select * from product where id=?";
        try {
            Product product =
                    qr.query(sql, new BeanHandler<>(Product.class), id);
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> list(String cid) {
        String sql = "select * from product where id in (select productid from productcate where categoryid = ?)";
        try{
            List<Product> products = qr.query(sql,new BeanListHandler<>(Product.class),cid);
            return products;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
