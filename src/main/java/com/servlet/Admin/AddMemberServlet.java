package com.servlet.Admin;

import com.service.Admin.AdminService;
import com.service.Admin.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddMemberServlet extends HttpServlet {
    //主要是查询出管理员可以查看到的老师和学生
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int kind = Integer.parseInt(req.getParameter("kind"));

        AdminService adminService = new AdminServiceImpl();
        if(kind==0){//添加学生
            String studentId = req.getParameter("studentId");
            String studentSex = req.getParameter("studentSex");
            String studentName = req.getParameter("studentName");
            String password = req.getParameter("password");
            String major= req.getParameter("major");
            String Class1=req.getParameter("Class1");
            int addInfo = adminService.addstudent(studentId,studentName,studentSex,major,Class1,password);
            if(addInfo!=1){
                resp.setStatus(404);
            }else {
                // 返回值简单处理
                resp.getWriter().write(addInfo);
            }
        }else if(kind==1){//添加老师
            String teacherId = req.getParameter("teacherId");
            String teacherName=req.getParameter("teacherName");
            String teacherSex=req.getParameter("teacherSex");
            String password = req.getParameter("password");
            String major= req.getParameter("major");
            int addInfo = adminService.addteacher(teacherId,teacherName,teacherSex,major,password);
            if(addInfo!=1){
                resp.setStatus(404);
            }else {
                resp.getWriter().write(addInfo);
            }
        }
//        else if(kind==2){//添加课程
//            String courseId = req.getParameter("courseId");
//            String courseName = req.getParameter("courseName");
//            String teacherId =req.getParameter("teacherId");
//            int addInfo=adminService.addcourse(courseId,courseName,teacherId);
//            if(addInfo!=1){
//                resp.setStatus(404);
//            } else {
//                resp.getWriter().write(addInfo);
//            }
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
