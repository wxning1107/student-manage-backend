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

public class SearchGradeServlet extends HttpServlet {
    //查询成绩
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从登录的那一刻用户的账号就被记录在session里了
        student student = (student) req.getSession().getAttribute("userSession");
        String studentId = student.getStudentId();
        StudentService studentService = new StudentServiceImpl();
        List<grade> goodsList = studentService.search(studentId);

        // 响应返回学生成绩
        resp.getWriter().write(JSON.parseArray(JSONObject.toJSONString(goodsList)).toJSONString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
