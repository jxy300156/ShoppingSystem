package com.iweb.controller.usercontroller;

import cn.hutool.json.JSONUtil;
import com.iweb.bean.User;
import com.iweb.bean.VO.ResultVo;
import com.iweb.controller.BaseServlet;
import com.iweb.service.UserService;
import com.iweb.service.impl.UserServiceImpl;
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
@WebServlet("/user")
public class UserLoginServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultVo resultVo = new ResultVo();
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        String correctCode = (String) session.getAttribute("code");
        if(!correctCode.equalsIgnoreCase(code)){
            resultVo.setMess("验证码错误");
        }else{
            User user = FormBeanUtil.formToBean(req.getParameterMap(), User.class);
            user = userService.login(user);

            if(user == null){
                resultVo.setMess("用户名或密码错误");
            }else{
                resultVo.setOk(true);
                session.setAttribute("user",user);
            }
        }
        resp.getWriter().write(JSONUtil.toJsonStr(resultVo));
    }

    public void verifyUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isExists =
                userService.verifyUsername(req.getParameter("username"));
        ResultVo resultVo = new ResultVo();
        if(isExists){
            resultVo.setOk(true);
            resultVo.setMess("用户已被注册");
        }
        resp.getWriter().write(JSONUtil.toJsonStr(resultVo));
    }

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =
                FormBeanUtil.formToBean(req.getParameterMap(), User.class);
        boolean addOK = userService.register(user);
        ResultVo resultVo = new ResultVo();
        if(addOK){
            resultVo.setOk(true);
            resultVo.setMess("注册成功^_^!!!");
        }
        resp.getWriter().write(JSONUtil.toJsonStr(resultVo));
    }

    public void getInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        ResultVo<User> resultVo = new ResultVo();
        resultVo.setT(user);
        resp.getWriter().write(JSONUtil.toJsonStr(resultVo));
    }

    public void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        resp.sendRedirect("userLogin.html");
    }
}
