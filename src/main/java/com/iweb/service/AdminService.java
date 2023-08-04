package com.iweb.service;

import com.iweb.bean.Admin;

/**
 * @author jxy
 * @date
 */
public interface AdminService {
    Admin login(Admin admin);
    boolean verifyUsername(String username);
    boolean register(Admin admin);
}
