package com.iweb.DAO.impl;

import com.iweb.DAO.OrderDAO;
import com.iweb.bean.Order;

import com.iweb.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author jxy
 * @date
 */
public class OrderDAOImpl implements OrderDAO {
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());
    @Override
    public List<Order> list(String uid) {
        String sql = "select * from `order` where id in (select orderid from userorder where userid = ?)";
        try{
            List<Order> orders = qr.query(sql,new BeanListHandler<>(Order.class),uid);
            return orders;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Order order) {
        String sql = "insert into `order` values(?,?)";
        try{
            int count = qr.update(sql,order.getId(),order.getOrderDetailId());
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "delete from `order` where id = ?";
        try{
            int count = qr.update(sql,id);
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
