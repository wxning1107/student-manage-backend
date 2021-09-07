package com.servlet.Teacher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.DescriptorProtos;
import com.pojo.grade;
import com.pojo.student;
import com.pojo.teacher;
import com.service.Teacher.TeacherService;
import com.service.Teacher.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Search_or_update_GradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        teacher teacher= (teacher) req.getSession().getAttribute("userSession");
        String teacherId = teacher.getTeacherId();
//        String teacherId = "001";
        Integer kind = Integer.valueOf(req.getParameter("kind"));
        TeacherService teacherService = new TeacherServiceImpl();
        if (kind == 1) {//根据课程查
            String courseId = req.getParameter("coursetId");
            try {
                List<grade> goodsList = teacherService.search(teacherId, courseId);

                // 响应返回课程
                resp.getWriter().write(JSON.parseArray(JSONObject.toJSONString(goodsList)).toJSONString());

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (kind == 2) {
            //根据课程、专业查
            String courseId = req.getParameter("coursetId");
            String major = req.getParameter("major");
            try {
                List<grade> goodsList = teacherService.search(teacherId, courseId, major);
                // 响应返回课程
                resp.getWriter().write(JSON.parseArray(JSONObject.toJSONString(goodsList)).toJSONString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (kind == 3) {//按照课程、专业、班级查
            String courseId = req.getParameter("coursetId");
            String major = req.getParameter("major");
            String Class1 = req.getParameter("Class1");
            try {
                List<grade> goodsList = teacherService.search(teacherId, courseId, major, Class1);
                // 响应返回课程
                resp.getWriter().write(JSON.parseArray(JSONObject.toJSONString(goodsList)).toJSONString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        teacher teacher= (teacher) req.getSession().getAttribute("userSession");
        String teacherId = teacher.getTeacherId();
//        String teacherId = "001";

        BufferedReader reader = req.getReader();
        // 接收用户端传来的body体里的数据
        String readerStr = "";
        String line;
        while ((line = reader.readLine()) != null) {
            readerStr = readerStr.concat(line);
        }

        TeacherService teacherService = new TeacherServiceImpl();
        JSONArray bodyArray = JSONArray.parseArray(readerStr);
        int updateSum = 0;
        for (Object obj : bodyArray) {
            JSONObject jsonObject = JSONObject.parseObject(obj.toString());
            System.out.println(jsonObject.getString("studentId"));
            System.out.println(jsonObject.getString("courseId"));
            System.out.println(jsonObject.getString("grade1"));

            updateSum = teacherService.update(teacherId, jsonObject.getString("studentId"),
                    jsonObject.getString("courseId"), Integer.parseInt(jsonObject.getString("grade1")));
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("errcode", "0");
        map.put("errmsg", "");
        map.put("data", Integer.toString(updateSum));

        resp.getWriter().write(map.toString());
    }
}
