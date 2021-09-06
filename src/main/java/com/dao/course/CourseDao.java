package com.dao.course;

import com.pojo.course;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    //查询所有课程
    public List<course> search(Connection connection)throws SQLException;
}
