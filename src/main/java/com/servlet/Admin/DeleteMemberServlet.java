package com.servlet.Admin;

import com.service.Admin.AdminService;
import com.service.Admin.AdminServiceImpl;
import com.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteMemberServlet extends HttpServlet {
    //删除用的
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        AdminService adminService=new AdminServiceImpl();
        int result=0;
        Integer kind = Integer.valueOf(req.getParameter("kind"));
        if(kind==0) {//删除学生
            try {
                String studentId = req.getParameter("studentId");
                result = adminService.deleteStudent(studentId);
                if(result==0){
                    req.setAttribute("msg","删除失败");
                    req.getRequestDispatcher("/shop_list.jsp").forward(req,resp);//回到管理员页面
                }else {
                    resp.sendRedirect("home.jsp");//回到管理员页面或者你想的页面
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(kind==1){//删除老师
            String teacherId = req.getParameter("teacherId");
            try {
                result = adminService.deleteTeacher(teacherId);
                if(result==0){
                    req.setAttribute("msg","删除失败");
                    req.getRequestDispatcher("/shop_list.jsp").forward(req,resp);//回到管理员页面
                }else {
                    resp.sendRedirect("home.jsp");//回到管理员页面或者你想的页面
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(kind==2){//删除课程
            String courseId = req.getParameter("courseId");
            try {
                result = adminService.deleteTeacher(courseId);
                if(result==0){
                    req.setAttribute("msg","删除失败");
                    req.getRequestDispatcher("/shop_list.jsp").forward(req,resp);//回到管理员页面
                }else {
                    resp.sendRedirect("home.jsp");//回到管理员页面或者你想的页面
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
