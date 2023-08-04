package com.iweb.DAO.impl;

import com.iweb.DAO.AddressDAO;

import com.iweb.bean.Address;
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
public class AddressDAOImpl implements AddressDAO {
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());
    @Override
    public List<Address> list(String uid) {
        String sql = "select * from address where id in (select addressid from useraddress where userid = ?)";
        try{
            List<Address> addresses = qr.query(sql,new BeanListHandler<>(Address.class),uid);
            return addresses;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Address address) {
        String sql = "insert into address values(?,?,?,?,?)";
        try{
            int count = qr.update(sql,address.getId(),address.getProvince(),
                    address.getCity(),address.getArea(),address.getStreet());
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "delete from address where id = ?";
        try{
            int count = qr.update(sql,id);
            return count>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Address address) {
        String sql = "update address set province = ?, city = ?,area = ?,street = ? where id = ?";
        try {
            int count = qr.update(sql,address.getProvince(),address.getCity(), address.getArea(),
                    address.getStreet(),address.getId());
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Address get(String id) {
        String sql = "select * from address where id = ?";
        try{
            Address a = qr.query(sql,new BeanHandler<>(Address.class),id);
            return a;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
