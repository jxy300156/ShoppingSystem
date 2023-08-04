package com.iweb.controller.orderdetailcontroller;


import com.iweb.bean.Address;
import com.iweb.bean.Cart;
import com.iweb.bean.User;
import com.iweb.service.AddressService;
import com.iweb.service.CartService;
import com.iweb.service.impl.AddressServiceImpl;
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
@WebServlet("/confirmOrderDetail")
public class ConfirmOrderDetailServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    private AddressService addressService = new AddressServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String id = req.getParameter("id");
        Cart c = cartService.get(id);
        List<Address> ads = addressService.list(user.getId());
        req.setAttribute("c",c);
        req.setAttribute("ads",ads);
        req.getRequestDispatcher("confirmOrderDetail.jsp").forward(req,resp);
    }
}
