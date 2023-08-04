package com.iweb.controller;

import com.alipay.api.internal.util.AlipaySignature;
import com.iweb.service.OrderDetailService;
import com.iweb.service.impl.OrderDetailServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jxy
 * @date
 */
@WebServlet("/notify")
public class NotifyServlet extends HttpServlet {
    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();
    @SneakyThrows
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = req.getParameterMap();
        for (String key : requestParams.keySet()) {
            String[] values = requestParams.get(key);
            StringBuilder valueStr = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                System.out.println(values[i]);
                valueStr.append((i == values.length - 1) ? values[i] : values[i] + ",");
            }
            params.put(key, valueStr.toString());
        }
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgBvhE7dTtadvt1Gd04PuXaE4uD7Jdrw3DQ4q/fpjUJBhqHVlAUVlt42KKpsWEoBbWcQL23YJiopVqWxPczhecFK78aGf+6vEvrzRElg3c86PAY3F4gk71om3jbwXrVBGzin8cSCekBGUU8qdKDQe2/myK5CUlGp82y6M1Vlu+VPm8/VKccYj3xoaIvryJwZ5w8hd/tXulNIC1WQXToxtg7EI/DRrcAve9M5p99rsLksgkEHNdQ4pxX/jdNLjwpx4eZ7Dg5oI7MoabzqONVkWE1ud9OFvpQThnP8NwGM5A4M2P8PMeVb9EMDHmfvmzGBZGQceYnz4pnPUOtcjv4JjuwIDAQAB";
        // 验证支付宝通知的合法性
        if (AlipaySignature.rsaCheckV1(params, publicKey, "UTF-8", "RSA2")) {

            resp.getWriter().write("success");
        } else {
            // 验证失败，返回错误响应给支付宝
            resp.getWriter().write("fail");
        }
    }
}
