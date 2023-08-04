package com.iweb.DAO.impl;

import com.iweb.DAO.AdminDAO;
import com.iweb.bean.Admin;
import com.iweb.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * @author jxy
 * @date
 */
public class AdminDAOImpl implements AdminDAO {
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());

    @Override
    public Admin login(Admin admin) {
        String sql = "select * from admin where username = ? and password = ?";
        try{
            admin = qr.query(sql,new BeanHandler<>(Admin.class), admin.getUsername(), admin.getPassword());
        }catch (SQLException e){

        }
        return admin;
    }

    @Override
    public boolean verifyUsername(String username) {
        String sql = "select count(*) from admin where username = ?";
        try{
            Number number = (Number)qr.query(sql,new ScalarHandler<>(),username);
            return number.intValue()>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addAdmin(Admin admin) {
        String sql = "insert into admin values (?,?,?)";
        try{
            int result = qr.update(sql, admin.getId(), admin.getUsername(), admin.getPassword());
            return result>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
