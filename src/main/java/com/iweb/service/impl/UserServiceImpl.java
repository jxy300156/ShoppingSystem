package com.iweb.service.impl;

import com.iweb.DAO.UserDAO;
import com.iweb.DAO.impl.UserDAOImpl;
import com.iweb.bean.User;
import com.iweb.service.UserService;
import com.iweb.util.MD5Util;
import com.iweb.util.UUIDUtil;

/**
 * @author jxy
 * @date
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public User login(User user) {
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        return userDAO.login(user);
    }

    @Override
    public boolean verifyUsername(String username) {
        return userDAO.verifyUsername(username);
    }

    @Override
    public boolean register(User user) {
        boolean isExist = userDAO.verifyUsername(user.getUsername());
        if(isExist){
            return false;
        }else {
            user.setId(UUIDUtil.uuid());
            user.setPassword(MD5Util.getMD5(user.getPassword()));
            boolean isRegister = userDAO.addUser(user);
            if (isRegister){
                return true;
            }else {
                return false;
            }
        }
    }
}
