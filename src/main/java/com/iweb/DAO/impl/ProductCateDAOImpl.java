package com.iweb.DAO.impl;

import com.iweb.DAO.ProductCateDAO;
import com.iweb.bean.ProductCate;
import com.iweb.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author jxy
 * @date
 */
public class ProductCateDAOImpl implements ProductCateDAO {
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());
    @Override
    public boolean add(ProductCate productCate) {
        String sql = "insert into productcate values(?,?,?)";
        try{
            int count = qr.update(sql,productCate.getId(),productCate.getProductId(),
                    productCate.getCategoryId());
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ProductCate productCate) {
        String sql = "update productcate set categoryid = ? where productid = ?";
        try{
            int count = qr.update(sql,productCate.getCategoryId(),productCate.getProductId());
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(String pid) {
        String sql = "delete from productcate where productid = ?";
        try{
            int count = qr.update(sql,pid);
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ProductCate> list(String cid) {
        String sql = "select * from productcate where categoryid = ?";
        try{
            List<ProductCate> productCates = qr.query(sql,new BeanListHandler<>(ProductCate.class),cid);
            return productCates;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProductCate get(String pid) {
        String sql = "select * from productcate where productid = ?";
        try{
            ProductCate productCate = qr.query(sql,new BeanHandler<>(ProductCate.class),pid);
            return productCate;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
