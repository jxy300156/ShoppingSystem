package com.iweb.controller.orderdetailcontroller;


import com.iweb.bean.*;
import com.iweb.service.AddressService;
import com.iweb.service.CartService;
import com.iweb.service.OrderDetailService;
import com.iweb.service.OrderService;
import com.iweb.service.impl.AddressServiceImpl;
import com.iweb.service.impl.CartServiceImpl;
import com.iweb.service.impl.OrderDetailServiceImpl;
import com.iweb.service.impl.OrderServiceImpl;
import com.iweb.util.FormBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author jxy
 * @date
 */
@WebServlet("/addOrderDetail")
public class AddOrderDetailServlet extends HttpServlet {
    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private AddressService addressService = new AddressServiceImpl();
    private CartService cartService = new CartServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String userId = user.getId();
        Map<String,String[]> paramMap = req.getParameterMap();
        OrderDetail orderDetail = FormBeanUtil.formToBean(paramMap,OrderDetail.class);
        String cid = req.getParameter("cid");
        String addressId = req.getParameter("addressId");
        Cart c = cartService.get(cid);
        Address address = addressService.get(addressId);
        orderDetail.setProvince(address.getProvince());
        orderDetail.setCity(address.getCity());
        orderDetail.setArea(address.getArea());
        orderDetail.setStreet(address.getStreet());
        orderDetail.setProductName(c.getProductName());
        orderDetail.setCost(c.getTotalPrice());
        boolean isAdd1 = orderDetailService.add(orderDetail);
        if(isAdd1){
            Order order = new Order();
            order.setOrderDetailId(orderDetail.getId());
            boolean isAdd2 = orderService.add(order,userId);
            if(isAdd2){
                req.getRequestDispatcher("listOrder").forward(req,resp);
            }else {
                resp.getWriter().println("添加到订单失败！");
                resp.sendRedirect("listCart");
            }
        }else{
            resp.getWriter().println("添加到订单详情失败！");
            resp.sendRedirect("listCart");
        }
    }
}
