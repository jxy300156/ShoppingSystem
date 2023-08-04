package com.iweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iweb.bean.DataModel;
import com.iweb.bean.ProductCate;
import com.iweb.bean.VO.ResultVo;
import com.iweb.service.ProductCateService;
import com.iweb.service.impl.ProductCateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author jxy
 * @date
 */
@WebServlet("/changeProductCate")
public class ProductCateServlet extends HttpServlet {
    private ProductCateService productCateService = new ProductCateServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        }
        reader.close();
        ObjectMapper mapper = new ObjectMapper();
        DataModel data = mapper.readValue(jsonBuilder.toString(), DataModel.class);
        String productId = data.getProductId();
        System.out.println(productId);
        String categoryId = data.getCategoryId();
        System.out.println(categoryId);
        ProductCate productCate = productCateService.get(productId);
        productCate.setCategoryId(categoryId);
        ResultVo resultVo = new ResultVo();
        boolean isUpdate = productCateService.update(productCate);
        if(isUpdate){
            resultVo.setOk(true);
            resultVo.setMess("修改成功！");
        }else {
            resultVo.setOk(false);
            resultVo.setMess("修改失败！");
        }
    }
}
