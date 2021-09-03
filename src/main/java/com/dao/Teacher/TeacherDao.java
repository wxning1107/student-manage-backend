package com.dao.Teacher;

import com.pojo.grade;
import com.pojo.student;
import com.pojo.teacher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TeacherDao {
    //老师登录自己账号查询密码到servlet比对
    public teacher getLogin(Connection connection, String teacherId)throws SQLException;

    public int update(Connection connection,String teacherId,String studentId,String courseId,int grade)throws SQLException;

    //按课程查
    public List<grade> search(Connection connection, String teacherId, String courseId)throws SQLException;

    //按课程和专业查
    public List<grade> search(Connection connection,String teacherId,String courseId,String major)throws SQLException;

    //按课程和专业和班级查
    public List<grade> search(Connection connection,String teacherId,String courseId,String major, String Class1)throws SQLException;
}
