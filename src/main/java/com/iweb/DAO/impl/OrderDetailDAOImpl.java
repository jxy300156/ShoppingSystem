package com.iweb.DAO.impl;

import com.iweb.DAO.OrderDetailDAO;

import com.iweb.bean.OrderDetail;
import com.iweb.util.DruidUtil;
import com.iweb.util.UUIDUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author jxy
 * @date
 */
public class OrderDetailDAOImpl implements OrderDetailDAO {
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());
    @Override
    public boolean add(OrderDetail detail) {
        String sql = "insert into orderdetail values(?,?,?,?,?,?,?,?)";
        try{
            int count = qr.update(sql,detail.getId(),detail.getProvince(), detail.getCity(),detail.getArea(),
                    detail.getStreet(), detail.getProductName(), detail.getCost(),detail.getState());
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "delete from orderdetail where id = ?";
        try{
            int count = qr.update(sql,id);
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public OrderDetail get(String id) {
        OrderDetail od = null;
        String sql = "select * from orderdetail where id = ?";
        try {
            od = qr.query(sql,new BeanHandler<>(OrderDetail.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return od;
    }

    @Override
    public boolean update(OrderDetail detail) {
        String sql = "update orderdetail set state = ? where id = ?";
        try{
            int count = qr.update(sql,detail.getState(), detail.getId());
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
