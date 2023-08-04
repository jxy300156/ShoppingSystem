package com.iweb.controller.addresscontroller;

import com.iweb.bean.User;
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
@WebServlet("/deleteAddress")
public class DeleteAddressServlet extends HttpServlet {
    private AddressService addressService = new AddressServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        boolean isDelete = addressService.delete(id);
        if(isDelete){
            resp.sendRedirect("listAddress");
        }else{
            resp.getWriter().println("删除地址信息失败！");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }
    }
}
