package com.iweb.controller.cartcontroller;

import com.iweb.bean.Cart;
import com.iweb.bean.Product;
import com.iweb.bean.User;
import com.iweb.service.CartService;
import com.iweb.service.ProductService;
import com.iweb.service.impl.CartServiceImpl;
import com.iweb.service.impl.ProductServiceImpl;
import com.iweb.util.FormBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author jxy
 * @date
 */
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        String userId = user.getId();
        Map<String,String[]> paramMap = req.getParameterMap();
        Cart cart = FormBeanUtil.formToBean(paramMap,Cart.class);
        String pid = req.getParameter("id");
        Product p = productService.accurateGet(pid);
        BigDecimal totalPrice =  p.getPrice().multiply(BigDecimal.valueOf(cart.getQuantity()));
        cart.setProductName(p.getName());
        cart.setTotalPrice(totalPrice);
        boolean isAdd = cartService.add(cart,userId);
        if(isAdd){
            req.setAttribute("p",p);
            resp.sendRedirect("listCart");
        }else {
            resp.getWriter().println("添加到购物车失败！");
            resp.sendRedirect("listAllProduct");
        }
    }
}
