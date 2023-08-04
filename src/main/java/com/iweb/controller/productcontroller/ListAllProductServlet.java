package com.iweb.controller.productcontroller;


import com.iweb.bean.Product;
import com.iweb.service.ProductService;
import com.iweb.service.impl.ProductServiceImpl;

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
@WebServlet("/listAllProduct")
public class ListAllProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> ps = productService.listAll();
        req.setAttribute("ps",ps);
        req.getRequestDispatcher("listAllProduct.jsp").forward(req,resp);
    }
}
