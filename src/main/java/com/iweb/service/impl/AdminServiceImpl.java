package com.iweb.service.impl;

import com.iweb.DAO.AdminDAO;
import com.iweb.DAO.impl.AdminDAOImpl;
import com.iweb.bean.Admin;
import com.iweb.service.AdminService;
import com.iweb.util.MD5Util;
import com.iweb.util.UUIDUtil;

/**
 * @author jxy
 * @date
 */
public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO = new AdminDAOImpl();

    @Override
    public Admin login(Admin admin) {
        admin.setPassword(MD5Util.getMD5(admin.getPassword()));
        return adminDAO.login(admin);
    }

    @Override
    public boolean verifyUsername(String username) {
        return adminDAO.verifyUsername(username);
    }

    @Override
    public boolean register(Admin admin) {
        boolean isExist = adminDAO.verifyUsername(admin.getUsername());
        if(isExist){
            return false;
        }else {
            admin.setId(UUIDUtil.uuid());
            admin.setPassword(MD5Util.getMD5(admin.getPassword()));
            boolean isRegister = adminDAO.addAdmin(admin);
            if (isRegister){
                return true;
            }else {
                return false;
            }
        }
    }
}
