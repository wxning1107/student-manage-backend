package com.dao.Student;

import com.pojo.grade;
import com.pojo.student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    //查询成绩表的成绩
    public List<grade> search(Connection connection, String studentId) throws SQLException;

    //登录的时候查自己的密码传到servlet验证
    public student getLogin(Connection connection, String studentId) throws SQLException;

    // 获取所有班级，由于数据库没有设计班级表，所以只有放到学生dao。学生表数据量较小，可以用该方法。
    public List<String> getAllClasses(Connection connection) throws SQLException;

    // 获取所有专业，由于数据库没有设计班级表，所以只有放到学生dao。学生表数据量较小，可以用该方法。
    public List<String> getAllMajors(Connection connection) throws SQLException;

    // 获取所有学生，未分页
    public List<student> search(Connection connection) throws SQLException;
}
