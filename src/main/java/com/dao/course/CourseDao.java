package com.dao.course;

import com.pojo.course;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    //查询所有课程
    public List<course> search(Connection connection) throws SQLException;

    // 添加课程
    public int add(Connection connection, String courseID, String courseName, String teacherId) throws SQLException;

    // 更新课程
    public int update(Connection connection, String courseID, String courseName, String teacherId) throws SQLException;

    // 删除课程
    public int delete(Connection connection, String courseID) throws SQLException;
}
