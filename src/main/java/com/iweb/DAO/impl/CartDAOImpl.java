package com.iweb.DAO.impl;

import com.iweb.DAO.CartDAO;
import com.iweb.bean.Cart;

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
public class CartDAOImpl implements CartDAO {
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());

    @Override
    public List<Cart> list(String uid) {
        String sql = "select * from cart where id in (select cartid from usercart where userid = ?)";
        try{
            List<Cart> carts = qr.query(sql,new BeanListHandler<>(Cart.class),uid);
            return carts;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Cart cart) {
        String sql = "insert into cart values(?,?,?,?)";
        try{
            int count = qr.update(sql,cart.getId(),cart.getProductName(),cart.getQuantity(),cart.getTotalPrice());
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Cart cart) {
        String sql = "update cart set quantity = ?, totalprice = ? where id = ?";
        try {
            int count = qr.update(sql, cart.getQuantity(), cart.getTotalPrice(), cart.getId());
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "delete from cart where id = ?";
        try{
            int count = qr.update(sql,id);
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Cart get(String id) {
        Cart c = null;
        String sql = "select * from cart where id = ?";
        try {
            c = qr.query(sql,new BeanHandler<>(Cart.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

}
