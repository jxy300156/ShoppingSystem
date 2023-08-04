package com.iweb.service;

import com.iweb.bean.Cart;


import java.util.List;

/**
 * @author jxy
 * @date
 */
public interface CartService {
    List<Cart> list(String uid);
    boolean add(Cart cart,String userId);
    boolean update(Cart cart);
    boolean delete(String id);
    Cart get(String id);
}
