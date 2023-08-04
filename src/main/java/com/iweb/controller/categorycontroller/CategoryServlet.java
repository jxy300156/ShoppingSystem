package com.iweb.controller.categorycontroller;

import cn.hutool.json.JSONUtil;
import com.iweb.bean.Category;
import com.iweb.bean.PageResult;
import com.iweb.bean.VO.ResultVo;
import com.iweb.controller.BaseServlet;
import com.iweb.service.CategoryService;
import com.iweb.service.ProductCateService;
import com.iweb.service.impl.CategoryServiceImpl;
import com.iweb.service.impl.ProductCateServiceImpl;

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
@WebServlet("/category")
public class CategoryServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    private ProductCateService productCateService = new ProductCateServiceImpl();
    public void listCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取当前页
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        //获取每页记录数
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        // 根据所接受的参数获取分页查询结果
        List<Category> categoryList = categoryService.list(pageIndex,pageSize);
        //查询总记录数
        int total = categoryService.count();
        // 新建分页结果对象
        PageResult<Category> pageResult = new PageResult<>();
        pageResult.setTotal(total);
        pageResult.setData(categoryList);
        resp.getWriter().write(JSONUtil.toJsonStr(pageResult));
    }
    public void addCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("categoryName");

        ResultVo resultVo = new ResultVo();
        if (categoryName.isEmpty()|| categoryName==null) {
            resultVo.setOk(false);
            resultVo.setMess("分类名称不可为空");
        }else {
            Category category = new Category();
            category.setName(categoryName);
            boolean isAdd = categoryService.add(category);
            if (!isAdd) {
                resultVo.setOk(false);
                resultVo.setMess("该分类已存在");
            } else {
                resultVo.setOk(true);
                resultVo.setMess("添加分类成功");
            }
        }
        resp.getWriter().write(JSONUtil.toJsonStr(resultVo));
    }
    public void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String ids = req.getParameter("ids");
        System.out.println(ids);
        ResultVo resultVo = new ResultVo();
        if(ids.equals("00fc569fc2604d82a9e74c68bcc48f9b")){
            resultVo.setOk(false);
            resultVo.setMess("该分类不可以删除！！！");
        }else if(ids!=null&&!ids.equals("")){
            boolean isMoved = productCateService.moveToOtherCategory(ids);
            if(isMoved) {
                boolean isDelete = categoryService.delete(ids);
                if(isDelete){
                    resultVo.setOk(true);
                    resultVo.setMess("删除成功！");
                }
            }
        }
        resp.getWriter().write(JSONUtil.toJsonStr(resultVo));
    }
}
