package com.iweb.DAO.impl;

import com.iweb.DAO.UserOrderDAO;
import com.iweb.bean.UserOrder;
import com.iweb.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author jxy
 * @date
 */
public class UserOrderDAOImpl implements UserOrderDAO {
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());
    @Override
    public boolean add(UserOrder userOrder) {
        String sql = "insert into userorder values(?,?,?)";
        try{
            int count = qr.update(sql,userOrder.getId(),userOrder.getUserId(),userOrder.getOrderId());
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String oid) {
        String sql = "delete from userorder where orderid = ?";
        try{
            int count = qr.update(sql,oid);
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
