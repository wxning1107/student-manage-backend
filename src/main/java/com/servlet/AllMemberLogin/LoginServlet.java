package com.servlet.AllMemberLogin;

import com.pojo.admin;
import com.pojo.student;
import com.pojo.teacher;
import com.service.Admin.AdminService;
import com.service.Admin.AdminServiceImpl;
import com.service.Student.StudentService;
import com.service.Student.StudentServiceImpl;
import com.service.Teacher.TeacherService;
import com.service.Teacher.TeacherServiceImpl;
import com.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//获取用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        ///和数据库的密码进行对比，调用业务层
        AdminService adminService = new AdminServiceImpl();
        admin admin;
        StudentService studentService = new StudentServiceImpl();
        student student;
        TeacherService teacherService = new TeacherServiceImpl();
        teacher teacher;

        Integer kind = Integer.valueOf(req.getParameter("kind"));
        System.out.println(kind);
        if(kind==0) {
            try {
                admin = adminService.getLogin(userCode);//这里已经把登录的人给查出来了
                if(admin!=null&&userPassword.equals(admin.getPassword())){//查有此人，可以登录
                    //将用户的信息放到session中
                    req.getSession().setAttribute(Constants.USER_SESSION,admin);
                    //跳转到内部主页
                    resp.sendRedirect("home.jsp");//这里是验证成功，跳转到管理员的jsp
                }else {
                    //转发回登录页面，顺带提示它错误
                    req.setAttribute("error","用户名或者密码不正确");
                    req.getRequestDispatcher("/login.jsp").forward(req,resp);//密码账号不对，跳转回登陆页面
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(kind==1){
            try {
                student = studentService.getLogin(userCode);
                if(student!=null&&userPassword.equals(student.getPassword())){//查有此人，可以登录
                    //将用户的信息放到session中
                    req.getSession().setAttribute(Constants.USER_SESSION,student);
                    //跳转到内部主页
                    resp.sendRedirect("home.jsp");//这里是验证成功，跳转到学生jsp
                }else {
                    //转发回登录页面，顺带提示它错误
                    req.setAttribute("error","用户名或者密码不正确");
                    req.getRequestDispatcher("/LoginServlet.jsp").forward(req,resp);//密码账号不对，跳转回登陆页面
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(kind==2){
            try {
                teacher = teacherService.getLogin(userCode);
                if(teacher!=null&&userPassword.equals(teacher.getPassword())){//查有此人，可以登录
                    //将用户的信息放到session中
                    req.getSession().setAttribute(Constants.USER_SESSION,teacher);
                    //跳转到内部主页
                    resp.sendRedirect("home.jsp");//这里是验证成功，跳转到老师的jsp
                }else {
                    //转发回登录页面，顺带提示它错误
                    req.setAttribute("error","用户名或者密码不正确");
                    req.getRequestDispatcher("/LoginServlet.jsp").forward(req,resp);//密码账号不对，跳转回登陆页面
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
