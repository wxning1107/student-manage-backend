package com.service.Admin;

import com.pojo.admin;
import com.pojo.teacher;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface AdminService {
    //管理员登录时的验证
    public admin getLogin(String adminCode)throws SQLException;

    public int addstudent(String studentId,String studentName,String studentSex,String major,String Class1,String password);
    public int addteacher(String teacherId,String teacherName,String teacherSex,String major,String password);
    public int addcourse(String classId, String className, String teacherId);
    public int addgrade(String teacherId,String studentId,String courseId,int grade);

    public int deleteStudent(String studentId)throws SQLException;
    public int deleteTeacher(String teacherId)throws SQLException;
    public int deleteCourse(String courseId)throws SQLException;

    // 查询所有管理员
    public List<admin> search();
}
