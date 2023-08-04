package com.iweb.controller.cartcontroller;

import com.iweb.bean.Product;
import com.iweb.service.ProductService;
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
@WebServlet("/confirmAddCart")
public class ConfirmAddCartServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("id");
        Product p = productService.accurateGet(pid);
        req.setAttribute("p",p);
        req.getRequestDispatcher("confirmCart.jsp").forward(req,resp);
    }
}
