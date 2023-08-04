package com.iweb.controller.cartcontroller;


import com.iweb.bean.Cart;
import com.iweb.service.CartService;
import com.iweb.service.ProductService;
import com.iweb.service.impl.CartServiceImpl;
import com.iweb.service.impl.ProductServiceImpl;

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
@WebServlet("/editCart")
public class EditCartServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Cart c = cartService.get(id);
        req.setAttribute("c",c);
        req.getRequestDispatcher("editCart.jsp").forward(req,resp);
    }
}
