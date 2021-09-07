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

    public CourseServiceImpl() {
        courseDao = new CourseDaoImpl();
    }

    @Override
    public List<course> search() {
        Connection connection = null;
        List<course> CourseList = null;
        try {
            connection = BaseDao.getConnection();
            CourseList = courseDao.search(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return CourseList;
    }

    @Override
    public int add(String classId, String courseName, String teacherId) {
        Connection connection = null;
        int addInfo = 0;

        try {
            connection = BaseDao.getConnection();
            // 通过业务层调用对应的具体数据库操作
            addInfo = courseDao.add(connection, classId, courseName, teacherId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return addInfo;
    }

    @Override
    public int update(String courseID, String courseName, String teacherID) {
        Connection connection = null;
        int updateInfo = 0;

        try {
            connection = BaseDao.getConnection();
            // 通过业务层调用对应的具体数据库操作
            updateInfo = courseDao.update(connection, courseID, courseName, teacherID);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return updateInfo;
    }

    @Override
    public int delete(String courseID) {
        Connection connection = null;
        int delInfo = 0;

        try {
            connection = BaseDao.getConnection();
            // 通过业务层调用对应的具体数据库操作
            delInfo = courseDao.delete(connection, courseID);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return delInfo;
    }
}
