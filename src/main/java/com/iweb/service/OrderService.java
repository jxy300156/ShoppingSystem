package com.iweb.service;

import com.iweb.bean.Order;


import java.util.List;

/**
 * @author jxy
 * @date
 */
public interface OrderService {
    List<Order> list(String uid);
    boolean add(Order order,String uid);
    boolean delete(String id);
}
