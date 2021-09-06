package com.servlet.Student;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pojo.grade;
import com.pojo.student;
import com.service.Student.StudentService;
import com.service.Student.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class getStudentClassServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();

        // 响应返回学生成绩
        resp.getWriter().write(studentService.getAllClasses().toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
