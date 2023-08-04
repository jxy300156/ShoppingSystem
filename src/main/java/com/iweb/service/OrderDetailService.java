package com.iweb.service;

import com.iweb.bean.OrderDetail;


/**
 * @author jxy
 * @date
 */
public interface OrderDetailService {
    boolean add(OrderDetail detail);
    boolean delete(String id);
    boolean update(OrderDetail detail);
    OrderDetail get(String id);
}
