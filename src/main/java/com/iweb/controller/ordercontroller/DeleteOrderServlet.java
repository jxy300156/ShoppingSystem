package com.iweb.controller.ordercontroller;

import com.iweb.service.OrderDetailService;
import com.iweb.service.OrderService;
import com.iweb.service.impl.OrderDetailServiceImpl;
import com.iweb.service.impl.OrderServiceImpl;

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
@WebServlet("/deleteOrder")
public class DeleteOrderServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();
    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String detailId = req.getParameter("detailId");
        boolean isDelete1 = orderDetailService.delete(detailId);
        if(isDelete1){
            boolean isDelete2 = orderService.delete(id);
            if(isDelete2){
                req.getRequestDispatcher("listOrder.jsp").forward(req,resp);
            }else {
                resp.getWriter().println("删除订单失败！");
                resp.sendRedirect("listOrder");
            }
        }else {
            resp.getWriter().println("删除订单详情失败！");
            resp.sendRedirect("listOrder");
        }
    }
}
