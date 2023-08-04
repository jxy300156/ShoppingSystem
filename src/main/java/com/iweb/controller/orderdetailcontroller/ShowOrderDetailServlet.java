package com.iweb.controller.orderdetailcontroller;


import com.iweb.bean.OrderDetail;
import com.iweb.service.OrderDetailService;
import com.iweb.service.impl.OrderDetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jxy
 * @date
 */
@WebServlet("/showOrderDetail")
public class ShowOrderDetailServlet extends HttpServlet {
    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        OrderDetail orderDetail = orderDetailService.get(id);
        req.setAttribute("od",orderDetail);
        req.getRequestDispatcher("showOrderDetail.jsp").forward(req,resp);
    }
}
