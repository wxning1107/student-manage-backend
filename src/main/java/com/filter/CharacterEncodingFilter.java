package com.filter;




import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public  class CharacterEncodingFilter implements Filter {


    private String encoding;

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpServletResponse resp = (HttpServletResponse) response;
        resp.addHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        resp.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        resp.addHeader("Access-Control-Allow-Credentials","true");
        resp.addHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type,authorization");
        resp.addHeader("Access-Control-Max-Age", "1800");//30 min

        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
