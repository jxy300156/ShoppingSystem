package com.iweb.DAO.impl;

import com.iweb.DAO.UserCartDAO;
import com.iweb.bean.UserCart;
import com.iweb.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author jxy
 * @date
 */
public class UserCartDAOImpl implements UserCartDAO {
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());

    @Override
    public boolean add(UserCart userCart) {
        String sql = "insert into usercart values(?,?,?)";
        try{
            int count = qr.update(sql,userCart.getId(),userCart.getUserId(),userCart.getCartId());
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String cid) {
        String sql = "delete from usercart where cartid = ?";
        try{
            int count = qr.update(sql,cid);
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
