package com.iweb.controller.categorycontroller;

import com.iweb.bean.Category;
import com.iweb.service.CategoryService;
import com.iweb.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author jxy
 * @date
 */
@WebServlet("/listCategory")
public class CategoryListServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> cs = categoryService.list();
        req.setAttribute("cs",cs);
        req.getRequestDispatcher("listCategory.jsp").forward(req,resp);
    }
}
