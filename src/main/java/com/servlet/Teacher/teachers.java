package com.servlet.Teacher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.service.Student.StudentService;
import com.service.Student.StudentServiceImpl;
import com.service.Teacher.TeacherService;
import com.service.Teacher.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class teachers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        TeacherService teacherService = new TeacherServiceImpl();

        // 响应返回所有教师，未分页
        resp.getWriter().write(JSON.parseArray(JSONObject.toJSONString(teacherService.search())).toJSONString());
    }
}
