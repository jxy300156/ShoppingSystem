package com.iweb.controller.productcontroller;

import cn.hutool.json.JSONUtil;
import com.iweb.bean.Category;
import com.iweb.bean.PageResult;
import com.iweb.bean.Product;
import com.iweb.bean.ProductCate;
import com.iweb.bean.VO.ResultVo;
import com.iweb.controller.BaseServlet;
import com.iweb.service.CategoryService;
import com.iweb.service.ProductCateService;
import com.iweb.service.ProductService;
import com.iweb.service.impl.CategoryServiceImpl;
import com.iweb.service.impl.ProductCateServiceImpl;
import com.iweb.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author jxy
 * @date
 */
@WebServlet("/product")
public class ProductServlet extends BaseServlet {
    private ProductService productService = new ProductServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();
    private ProductCateService productCateService = new ProductCateServiceImpl();
    public void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        List<Product> productList = productService.list(pageIndex,pageSize);
        int total = productService.count();
        PageResult<Product> pageResult = new PageResult<>();
        pageResult.setTotal(total);
        pageResult.setData(productList);
        resp.getWriter().write(JSONUtil.toJsonStr(pageResult));
    }
    public void queryAllCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.queryAllCategory();
        resp.getWriter().write(JSONUtil.toJsonStr(categories));
    }
    public void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = req.getParameter("data");
        Product product = JSONUtil.toBean(data, Product.class);
        ProductCate productCate = new ProductCate();
        ResultVo resultVo = new ResultVo();
        boolean isAdd = productService.add(product);
        if (isAdd) {
            productCate.setProductId(product.getId());
            productCate.setCategoryId("00fc569fc2604d82a9e74c68bcc48f9b");
            boolean addCate = productCateService.add(productCate);
            if(addCate){
                resultVo.setOk(true);
                resultVo.setMess("商品添加成功");
            }else {
                resultVo.setOk(false);
                resultVo.setMess("未知错误无法添加商品");
            }
        } else {
            resultVo.setOk(false);
            resultVo.setMess("商品已经存在");
        }
        resp.getWriter().write(JSONUtil.toJsonStr(resultVo));
    }
    public void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = req.getParameter("data");
        System.out.println(data);
        Product product = JSONUtil.toBean(data, Product.class);
        ResultVo resultVo = new ResultVo();
        boolean updateOk = productService.update(product);
        if(updateOk){
            resultVo.setOk(true);
            resultVo.setMess("修改商品成功");
        }
        resp.getWriter().write(JSONUtil.toJsonStr(resultVo));
    }
    public void queryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = productService.queryById(id);
        resp.getWriter().write(JSONUtil.toJsonStr(product));
    }
    public void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String ids = req.getParameter("ids");
        System.out.println(ids);
        ResultVo resultVo = new ResultVo();
        boolean isDelete = productService.delete(ids);
        if(isDelete){
            boolean deleteCate = productCateService.deleteProduct(ids);
            if(deleteCate) {
                resultVo.setOk(true);
                resultVo.setMess("删除商品成功");
            }
        }
        resp.getWriter().write(JSONUtil.toJsonStr(resultVo));
    }
    public void listCateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String cid = req.getParameter("id");
        List<Product> productList = productService.list(cid);
        int total = productService.count();
        PageResult<Product> pageResult = new PageResult<>();
        pageResult.setTotal(total);
        pageResult.setData(productList);
        resp.getWriter().write(JSONUtil.toJsonStr(pageResult));
    }
}
