package com.iweb.controller.orderdetailcontroller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayOpenPublicTemplateMessageIndustryModifyRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayOpenPublicTemplateMessageIndustryModifyResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.iweb.bean.OrderDetail;
import com.iweb.bean.VO.ResultVo;
import com.iweb.service.OrderDetailService;
import com.iweb.service.impl.OrderDetailServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

/**
 * @author jxy
 * @date
 */
@WebServlet("/payOrder")
public class PayOrderServlet extends HttpServlet {
    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();

    @SneakyThrows
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Properties properties = new Properties();
        InputStream is = new FileInputStream("D:\\idea_work_space\\ShoppingSystem\\src\\main\\resources\\alipay.properties");
        properties.load(is);
        String URL = properties.getProperty("URL");
        String APPID = properties.getProperty("APPID");
        String PRIVATE_KEY = properties.getProperty("PRIVATE_KEY");
        String FORMAT = properties.getProperty("FORMAT");
        String CHARSET = properties.getProperty("CHARSET");
        String SIGN_TYPE = properties.getProperty("SIGN_TYPE");
        String ALIPAY_PUBLIC_KEY = properties.getProperty("ALIPAY_PUBLIC_KEY");

        AlipayClient alipayClient = new DefaultAlipayClient(URL, APPID, PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        // 异步接收地址，仅支持http/https，公网可访问
        request.setNotifyUrl("http://localhost:8080/notify");
        // 同步跳转地址，仅支持http/https
        request.setReturnUrl("http://localhost:8080/success.jsp");

        /******必传参数******/
        JSONObject bizContent = new JSONObject();
        // 商户订单号，商家自定义，保持唯一性
        String orderId = req.getParameter("orderId");
        bizContent.put("out_trade_no", orderId);
        // 支付金额，最小值0.01元
        String cost = req.getParameter("cost");
        bizContent.put("total_amount", cost);
        // 订单标题，不可使用特殊符号
        String productName = req.getParameter("productName");
        bizContent.put("subject", productName);
        // 电脑网站支付场景固定传值FAST_INSTANT_TRADE_PAY
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");

        request.setBizContent(bizContent.toString());
        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);

        // 调用支付宝支付接口成功后，直接跳转支付宝页面进行支付
        if (response.isSuccess()) {
            String form = response.getBody();
            resp.setContentType("text/html;charset=" + CHARSET);
            resp.getWriter().write(form);
        } else {
            System.out.println("调用失败");
        }
    }
}