package com.iweb.DAO;

import com.iweb.bean.UserCart;

/**
 * @author jxy
 * @date
 */
public interface UserCartDAO {
    boolean add(UserCart userCart);
    boolean delete(String cid);
}
