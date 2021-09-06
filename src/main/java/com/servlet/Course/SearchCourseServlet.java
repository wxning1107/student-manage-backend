package com.servlet.Course;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pojo.grade;
import com.pojo.course;
import com.service.Student.StudentService;
import com.service.Student.StudentServiceImpl;
import com.service.course.CourseService;
import com.service.course.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchCourseServlet extends HttpServlet {
    //查询课程
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从登录的那一刻用户的账号就被记录在session里了
        CourseService courseService = new CourseServiceImpl();
        List<course> courseList = courseService.search();

        // 响应返回学生成绩
        resp.getWriter().write(JSON.parseArray(JSONObject.toJSONString(courseList)).toJSONString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
