package com.iweb.DAO;

import com.iweb.bean.OrderDetail;

/**
 * @author jxy
 * @date
 */
public interface OrderDetailDAO {
    boolean add(OrderDetail detail);
    boolean delete(String id);
    boolean update(OrderDetail detail);
    OrderDetail get(String id);
}
