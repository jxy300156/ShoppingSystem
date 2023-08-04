package com.iweb.controller.addresscontroller;

import com.iweb.bean.Address;
import com.iweb.service.AddressService;
import com.iweb.service.impl.AddressServiceImpl;

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
@WebServlet("/editAddress")
public class EditAddressServlet extends HttpServlet {
    private AddressService addressService = new AddressServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Address address = addressService.get(id);
        req.setAttribute("ad",address);
        req.getRequestDispatcher("editAddress.jsp").forward(req,resp);
    }
}
