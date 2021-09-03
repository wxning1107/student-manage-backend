package com.servlet.Teacher;

import com.pojo.grade;
import com.pojo.student;
import com.pojo.teacher;
import com.service.Teacher.TeacherService;
import com.service.Teacher.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Search_or_update_GradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        teacher teacher= (teacher) req.getSession().getAttribute("userSession");
        String teacherId = teacher.getTeacherId();

        Integer kind = Integer.valueOf(req.getParameter("kind"));
        TeacherService teacherService= new TeacherServiceImpl();
        if(kind==0){//更新成绩
            String courseId = req.getParameter("coursetId");
            String studentId = req.getParameter("studentId");
            Integer grade = Integer.valueOf(req.getParameter("grade"));
            teacherService.update(teacherId,studentId,courseId,grade);
        }else if(kind==1){//根据课程查
            String courseId = req.getParameter("coursetId");
            try {
                List<grade> goodsList =teacherService.search(teacherId,courseId);
                req.setAttribute("goodsList", goodsList);
                //request必须要用转发，用重定向会消失
                req.getRequestDispatcher("women_goodslist.jsp").forward(req, resp);//老师页面里有的成绩
                //req.getRequestDispatcher("test.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (kind == 2) {
            //根据课程、专业查
            String courseId = req.getParameter("coursetId");
            String major = req.getParameter("major");
            try {
                List<grade> goodsList =teacherService.search(teacherId,courseId,major);
                req.setAttribute("goodsList", goodsList);
                //request必须要用转发，用重定向会消失
                req.getRequestDispatcher("women_goodslist.jsp").forward(req, resp);//老师页面里有的成绩
                //req.getRequestDispatcher("test.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(kind==3){//按照课程、专业、班级查
            String courseId = req.getParameter("coursetId");
            String major = req.getParameter("major");
            String Class1 = req.getParameter("Class1");
            try {
                List<grade> goodsList =teacherService.search(teacherId,courseId,major,Class1);
                req.setAttribute("goodsList", goodsList);
                //request必须要用转发，用重定向会消失
                req.getRequestDispatcher("women_goodslist.jsp").forward(req, resp);//老师页面里有的成绩
                //req.getRequestDispatcher("test.jsp").forward(req,resp);
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
