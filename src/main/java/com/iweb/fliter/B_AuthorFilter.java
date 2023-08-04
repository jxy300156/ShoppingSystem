package com.iweb.fliter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author jxy
 * @date
 */
@WebFilter("/*")
public class B_AuthorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
//        获取用户访问的URI
        String uri = req.getRequestURI();
        if(uri.endsWith("userLogin.html")|uri.endsWith("adminLogin.html")|uri.endsWith("/code")|uri.endsWith("/user")|uri.endsWith("/admin")|
        uri.endsWith(".jpg")|uri.endsWith(".png")|uri.endsWith(".css")|uri.endsWith(".js")|uri.endsWith(".jpeg")){
            chain.doFilter(req,resp);
            return;
        }
        HttpSession session = req.getSession();
        if(session.getAttribute("user")==null){
            resp.sendRedirect("userLogin.html");
            return;
        }else {
            chain.doFilter(req,resp);
        }

    }

    @Override
    public void destroy() {

    }
}
