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

        HttpServletRequest req = (HttpServletRequest)request;
        Enumeration e = req.getHeaderNames();
        System.out.println(">>>>>>>>>>>>>>>本次请求的header信息如下：");
        while(e.hasMoreElements()){
            String name = (String) e.nextElement();
            String value = req.getHeader(name);
            System.out.println(name+"="+value);
        }
        System.out.println(">>>>>>>>>>>>>>>本次请求的header信息结束");
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.addHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        resp.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        resp.addHeader("Access-Control-Allow-Credentials","true");
        resp.addHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
        resp.addHeader("Access-Control-Max-Age", "1800");//30 min

        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
