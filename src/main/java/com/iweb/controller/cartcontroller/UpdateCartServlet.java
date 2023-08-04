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
import java.math.BigDecimal;

/**
 * @author jxy
 * @date
 */
@WebServlet("/updateCart")
public class UpdateCartServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("id");
        Cart cart = cartService.get(cid);
        BigDecimal price = cart.getTotalPrice().divide(BigDecimal.valueOf(cart.getQuantity()));
        if(price==null){
            resp.getWriter().println("商品的价格有误！");
            resp.sendRedirect("listCart");
        }else {
            Integer quantity = Integer.valueOf(req.getParameter("quantity"));
            cart.setQuantity(quantity);
            BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(quantity));
            cart.setTotalPrice(totalPrice);
            boolean isUpdate = cartService.update(cart);
            if (isUpdate) {
                resp.sendRedirect("listCart");
            } else {
                resp.getWriter().println("修改购物车内的该条信息失败！");
                resp.sendRedirect("listCart");
            }
        }
    }
}
