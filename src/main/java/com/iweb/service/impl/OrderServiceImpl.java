package com.iweb.service.impl;

import com.iweb.DAO.OrderDAO;
import com.iweb.DAO.UserOrderDAO;
import com.iweb.DAO.impl.OrderDAOImpl;
import com.iweb.DAO.impl.UserOrderDAOImpl;
import com.iweb.bean.Order;
import com.iweb.bean.UserOrder;
import com.iweb.service.OrderService;
import com.iweb.util.UUIDUtil;

import java.util.List;

/**
 * @author jxy
 * @date
 */
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();
    private UserOrderDAO userOrderDAO = new UserOrderDAOImpl();
    @Override
    public List<Order> list(String uid) {
        return orderDAO.list(uid);
    }

    @Override
    public boolean add(Order order,String uid) {
        order.setId(UUIDUtil.uuid());
        boolean isAdd = orderDAO.add(order);
        if(isAdd){
            UserOrder userOrder = new UserOrder();
            userOrder.setId(UUIDUtil.uuid());
            userOrder.setUserId(uid);
            userOrder.setOrderId(order.getId());
            boolean addToUserOrder = userOrderDAO.add(userOrder);
            if(addToUserOrder){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        boolean isDelete = orderDAO.delete(id);
        if(isDelete){
            boolean deleteUserOrder = userOrderDAO.delete(id);
            if(deleteUserOrder){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
