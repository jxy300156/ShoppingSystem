package com.iweb.controller.cartcontroller;

import cn.hutool.json.JSONUtil;
import com.iweb.bean.VO.ResultVo;
import com.iweb.service.CartService;
import com.iweb.service.impl.CartServiceImpl;

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
@WebServlet("/deleteFromCart")
public class DeleteFromCartServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("id");
        boolean idDelete = cartService.delete(cid);
        ResultVo vo = new ResultVo();
        if(idDelete){
            vo.setOk(true);
            vo.setMess("success");
        }else {
            vo.setOk(false);
            vo.setMess("failed");
        }
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(JSONUtil.toJsonStr(vo));
    }
}
