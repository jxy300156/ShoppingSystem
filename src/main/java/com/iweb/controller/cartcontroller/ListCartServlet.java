package com.iweb.controller.cartcontroller;


import com.iweb.bean.Cart;
import com.iweb.bean.User;
import com.iweb.service.CartService;
import com.iweb.service.impl.CartServiceImpl;

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
@WebServlet("/listCart")
public class ListCartServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Cart> cs = cartService.list(user.getId());
        req.setAttribute("cs",cs);
        req.getRequestDispatcher("listCart.jsp").forward(req,resp);
    }
}
