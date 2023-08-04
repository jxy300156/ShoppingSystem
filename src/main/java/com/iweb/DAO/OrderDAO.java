package com.iweb.DAO;



import com.iweb.bean.Order;

import java.util.List;

/**
 * @author jxy
 * @date
 */
public interface OrderDAO {
    List<Order> list(String uid);
    boolean add(Order order);
    boolean delete(String id);
}
