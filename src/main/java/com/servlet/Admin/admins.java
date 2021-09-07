package com.servlet.Admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.service.Admin.AdminService;
import com.service.Admin.AdminServiceImpl;
import com.service.Teacher.TeacherService;
import com.service.Teacher.TeacherServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class admins extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        AdminService adminService = new AdminServiceImpl();

        // 响应返回所有管理员，未分页
        resp.getWriter().write(JSON.parseArray(JSONObject.toJSONString(adminService.search())).toJSONString());
    }
}
