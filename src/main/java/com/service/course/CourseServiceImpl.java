package com.service.course;

import com.dao.BaseDao;
import com.dao.course.CourseDao;
import com.dao.course.CourseDaoImpl;
import com.pojo.course;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CourseServiceImpl implements CourseService {

    CourseDao courseDao;
    public CourseServiceImpl(){courseDao = new CourseDaoImpl(); }

    @Override
    public List<course> search() {
        Connection connection=null;
        List<course> CourseList = null;
        try {
            connection= BaseDao.getConnection();
            CourseList = courseDao.search(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return CourseList;
    }
}
