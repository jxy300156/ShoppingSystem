package com.iweb.service;

import com.iweb.bean.User;

/**
 * @author jxy
 * @date
 */
public interface UserService {
    User login(User user);
    boolean verifyUsername(String username);
    boolean register(User user);
}
