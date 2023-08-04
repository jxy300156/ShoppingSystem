package com.iweb.service.impl;

import com.iweb.DAO.AddressDAO;
import com.iweb.DAO.UserAddressDAO;
import com.iweb.DAO.impl.AddressDAOImpl;

import com.iweb.DAO.impl.UserAddressDAOImpl;
import com.iweb.bean.Address;
import com.iweb.bean.User;
import com.iweb.bean.UserAddress;
import com.iweb.service.AddressService;
import com.iweb.util.UUIDUtil;

import java.util.List;

/**
 * @author jxy
 * @date
 */
public class AddressServiceImpl implements AddressService {
    private AddressDAO addressDAO = new AddressDAOImpl();
    private UserAddressDAO userAddressDAO = new UserAddressDAOImpl();
    @Override
    public List<Address> list(String uid) {
        return addressDAO.list(uid);
    }

    @Override
    public boolean add(Address address, String userId) {
        address.setId(UUIDUtil.uuid());
        boolean isAdd = addressDAO.add(address);
        if(isAdd) {
            UserAddress userAddress = new UserAddress();
            userAddress.setId(UUIDUtil.uuid());
            userAddress.setAddressId(address.getId());
            userAddress.setUserId(userId);
            boolean addToUserAddress = userAddressDAO.add(userAddress);
            if(addToUserAddress){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        boolean isDelete = addressDAO.delete(id);
        if(isDelete) {
            boolean deleteUserAddress = userAddressDAO.delete(id);
            if(deleteUserAddress){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public boolean update(Address address) {
        return addressDAO.update(address);
    }

    @Override
    public Address get(String id) {
        return addressDAO.get(id);
    }
}
