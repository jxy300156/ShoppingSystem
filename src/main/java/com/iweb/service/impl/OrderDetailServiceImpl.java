package com.iweb.service.impl;

import com.iweb.DAO.OrderDetailDAO;
import com.iweb.DAO.impl.OrderDetailDAOImpl;
import com.iweb.bean.OrderDetail;
import com.iweb.service.OrderDetailService;
import com.iweb.util.UUIDUtil;

/**
 * @author jxy
 * @date
 */
public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();

    @Override
    public boolean add(OrderDetail detail) {
        detail.setId(UUIDUtil.uuid());
        detail.setState((byte)0);
        return orderDetailDAO.add(detail);
    }

    @Override
    public boolean delete(String id) {
        return orderDetailDAO.delete(id);
    }

    @Override
    public boolean update(OrderDetail detail) {
        return orderDetailDAO.update(detail);
    }

    @Override
    public OrderDetail get(String id) {
        return orderDetailDAO.get(id);
    }
}
