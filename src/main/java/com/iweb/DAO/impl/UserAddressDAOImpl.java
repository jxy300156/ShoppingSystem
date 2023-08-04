package com.iweb.DAO.impl;

import com.iweb.DAO.UserAddressDAO;
import com.iweb.bean.UserAddress;
import com.iweb.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author jxy
 * @date
 */
public class UserAddressDAOImpl implements UserAddressDAO {
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());

    @Override
    public boolean add(UserAddress userAddress) {
        String sql = "insert into useraddress values(?,?,?)";
        try{
            int count = qr.update(sql,userAddress.getId(),userAddress.getUserId(),userAddress.getAddressId());
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String aid) {
        String sql = "delete from useraddress where addressid = ?";
        try{
            int count = qr.update(sql,aid);
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
