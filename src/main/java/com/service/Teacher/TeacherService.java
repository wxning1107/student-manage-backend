package com.service.Teacher;

import com.pojo.grade;
import com.pojo.teacher;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TeacherService {
    //老师登录自己账号查询密码到servlet比对
    public teacher getLogin(String teacherId)throws SQLException;

    public int update(String teacherId, String studentId, String courseId, int grade);
    //按课程查
    public List<grade> search(String teacherId, String courseId)throws SQLException;

    //按课程和专业查
    public List<grade> search(String teacherId,String courseId,String major)throws SQLException;

    //按课程和专业和班级查
    public List<grade> search(String teacherId,String courseId,String major, String Class1)throws SQLException;
}
