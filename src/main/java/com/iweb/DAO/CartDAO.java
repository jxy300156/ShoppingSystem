package com.iweb.DAO;

import com.iweb.bean.Cart;


import java.util.List;

/**
 * @author jxy
 * @date
 */
public interface CartDAO {
    List<Cart> list(String uid);
    boolean add(Cart cart);
    boolean update(Cart cart);
    boolean delete(String id);
    Cart get(String id);
}
