package com.dao.Admin;

import com.pojo.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface Admindao {
    //管理员登录时的验证
    public admin getLogin(Connection connection,String adminCode)throws SQLException;

    public int addstudent(Connection connection,String studentId, String studentName, String studentSex, String major, String Class1,String password)throws SQLException;
    public int addteacher(Connection connection,String teacherId,String teacherName,String teacherSex,String major,String password)throws SQLException;
    public int addcourse(Connection connection,String classId, String className,String teacherId)throws SQLException;
    public int addgrade(Connection connection,String teacherId,String studentId,String courseId,int grade)throws SQLException;
    public int deleteStudent(Connection connection,String studentId)throws SQLException;
    public int deleteTeacher(Connection connection,String teacherId)throws SQLException;
    public int deleteCourse(Connection connection,String courseId)throws SQLException;
}
