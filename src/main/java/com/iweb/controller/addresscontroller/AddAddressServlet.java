package com.iweb.controller.addresscontroller;


import com.iweb.bean.Address;
import com.iweb.bean.User;
import com.iweb.service.AddressService;
import com.iweb.service.impl.AddressServiceImpl;
import com.iweb.util.FormBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author jxy
 * @date
 */
@WebServlet("/addAddress")
public class AddAddressServlet extends HttpServlet {
    private AddressService addressService = new AddressServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String[]> paramMap = req.getParameterMap();
        Address address = FormBeanUtil.formToBean(paramMap,Address.class);
        User user = (User) req.getSession().getAttribute("user");
        String userId = user.getId();
        boolean isAdd = addressService.add(address,userId);
        if(isAdd){
            resp.sendRedirect("listAddress");
        }else{
            resp.getWriter().println("添加地址信息失败！");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }
    }
}
