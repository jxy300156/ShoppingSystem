package com.iweb.controller.ordercontroller;


import com.iweb.bean.Order;
import com.iweb.bean.User;
import com.iweb.service.OrderService;
import com.iweb.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author jxy
 * @date
 */
@WebServlet("/listOrder")
public class ListOrderServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        List<Order> orders = orderService.list(user.getId());
        req.setAttribute("ods",orders);
        req.getRequestDispatcher("listOrder.jsp").forward(req,resp);
    }
}
