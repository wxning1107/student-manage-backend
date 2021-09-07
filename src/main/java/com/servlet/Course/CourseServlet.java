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
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class CourseServlet extends HttpServlet {
    //查询课程
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 从登录的那一刻用户的账号就被记录在session里了
        CourseService courseService = new CourseServiceImpl();
        List<course> courseList = courseService.search();

        // 响应返回所有课程
        resp.getWriter().write(JSON.parseArray(JSONObject.toJSONString(courseList)).toJSONString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String readerStr = getBodyParams(req);

        JSONObject jsonObject = JSONObject.parseObject(readerStr);
        String courseId = jsonObject.getString("courseId");
        String courseName = jsonObject.getString("courseName");
        String teacherId = jsonObject.getString("teacherId");

        CourseService courseService = new CourseServiceImpl();
        int addInfo=courseService.add(courseId,courseName,teacherId);
        if(addInfo!=1){
            resp.setStatus(400);
        } else {
            resp.getWriter().write(addInfo);
        }
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String readerStr = getBodyParams(req);

        JSONObject jsonObject = JSONObject.parseObject(readerStr);
        String courseId = jsonObject.getString("courseId");
        String courseName = jsonObject.getString("courseName");
        String teacherId = jsonObject.getString("teacherId");
        if(courseId.equals("")) {
            resp.getWriter().write(400);
            return;
        }

        CourseService courseService = new CourseServiceImpl();
        int addInfo=courseService.update(courseId,courseName,teacherId);
        if(addInfo == 0){
            resp.setStatus(400);
        } else {
            resp.getWriter().write(addInfo);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String readerStr = getBodyParams(req);

        JSONObject jsonObject = JSONObject.parseObject(readerStr);
        String courseId = jsonObject.getString("courseId");
        if(courseId.equals("")) {
            resp.getWriter().write(400);
            return;
        }

        CourseService courseService = new CourseServiceImpl();
        int addInfo=courseService.delete(courseId);
        if(addInfo == 0){
            resp.setStatus(400);
        } else {
            resp.getWriter().write(addInfo);
        }
    }

    // 接收用户端传来的body体里的数据
    private String getBodyParams(HttpServletRequest req) throws IOException {
        BufferedReader reader = req.getReader();
        String readerStr = "";
        String line;
        while ((line = reader.readLine()) != null) {
            readerStr = readerStr.concat(line);
        }

        return readerStr;
    }
}
