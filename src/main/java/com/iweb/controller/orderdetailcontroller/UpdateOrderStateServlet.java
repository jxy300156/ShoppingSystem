package com.iweb.controller.orderdetailcontroller;

import com.iweb.bean.OrderDetail;
import com.iweb.bean.VO.ResultVo;
import com.iweb.service.OrderDetailService;
import com.iweb.service.impl.OrderDetailServiceImpl;

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
@WebServlet("/updateState")
public class UpdateOrderStateServlet extends HttpServlet {
    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("orderId");
        OrderDetail orderDetail = orderDetailService.get(id);
        ResultVo resultVo = new ResultVo();
        if(orderDetail!=null){
            orderDetail.setState((byte)1);
            boolean isUpdate = orderDetailService.update(orderDetail);
            if(isUpdate){
                resultVo.setOk(true);
            }else {
                resultVo.setOk(false);
                resultVo.setMess("更新失败！");
            }
        }else {
            resultVo.setOk(false);
            resultVo.setMess("对应订单不存在！");
        }
    }
}
