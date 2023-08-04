package com.iweb.controller.addresscontroller;


import com.iweb.bean.Address;
import com.iweb.bean.User;
import com.iweb.service.AddressService;
import com.iweb.service.impl.AddressServiceImpl;

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
@WebServlet("/listAddress")
public class ListAddressServlet extends HttpServlet {
    private AddressService addressService = new AddressServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        String uid = user.getId();
        System.out.println(uid);
        List<Address> ads = addressService.list(uid);
        req.setAttribute("ads",ads);
        req.getRequestDispatcher("listAddress.jsp").forward(req,resp);
    }
}
