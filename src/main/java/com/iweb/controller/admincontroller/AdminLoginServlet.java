package com.iweb.controller.admincontroller;

import cn.hutool.json.JSONUtil;
import com.iweb.bean.Admin;
import com.iweb.bean.VO.ResultVo;
import com.iweb.controller.BaseServlet;
import com.iweb.service.AdminService;
import com.iweb.service.impl.AdminServiceImpl;
import com.iweb.util.FormBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author jxy
 * @date
 */
@WebServlet("/admin")
public class AdminLoginServlet extends BaseServlet {
    private AdminService adminService = new AdminServiceImpl();
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultVo resultVo = new ResultVo();
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        String correctCode = (String) session.getAttribute("code");
        if(!correctCode.equalsIgnoreCase(code)){
            resultVo.setMess("验证码错误");
        }else{
            Admin admin = FormBeanUtil.formToBean(req.getParameterMap(), Admin.class);
            admin = adminService.login(admin);
            if(admin == null){
                resultVo.setMess("用户名或密码错误");
            }else{
                resultVo.setOk(true);
                session.setAttribute("user",admin);
            }
        }
        resp.getWriter().write(JSONUtil.toJsonStr(resultVo));
    }

    public void verifyUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isExists = adminService.verifyUsername(req.getParameter("username"));
        ResultVo resultVo = new ResultVo();
        if(isExists){
            resultVo.setOk(true);
            resultVo.setMess("用户已被注册");
        }
        resp.getWriter().write(JSONUtil.toJsonStr(resultVo));
    }

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin = FormBeanUtil.formToBean(req.getParameterMap(), Admin.class);
        boolean addOK = adminService.register(admin);
        ResultVo resultVo = new ResultVo();
        if(addOK){
            resultVo.setOk(true);
            resultVo.setMess("注册成功^_^!!!");
        }
        resp.getWriter().write(JSONUtil.toJsonStr(resultVo));
    }

    public void getInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin = (Admin) req.getSession().getAttribute("user");
        ResultVo<Admin> resultVo = new ResultVo();
        resultVo.setT(admin);
        resp.getWriter().write(JSONUtil.toJsonStr(resultVo));
    }

    public void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        resp.sendRedirect("adminLogin.html");
    }
}
