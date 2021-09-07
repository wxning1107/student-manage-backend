package com.dao.course;

import com.dao.BaseDao;
import com.pojo.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public List<course> search(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<course> CourseList = new ArrayList<course>();
        if (connection != null) {
            String sql = "select * from course";
            course course;
            Object[] params = {};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while (rs.next()) {
                course = new course();
                course.setId(rs.getString("courseId"));
                course.setName(rs.getString("courseName"));
                course.setTeacherId(rs.getString("teacherId"));
                CourseList.add(course);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return CourseList;
    }

    @Override
    public int add(Connection connection, String courseID, String courseName, String teacherId) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int execute = 0;
        if (connection != null) {
            String sql = "insert into course values (?,?,?);";
            Object[] params = {courseID, courseName, teacherId};
            execute = BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null, pstm, rs);
            return execute;
        }
        return 0;
    }

    @Override
    public int update(Connection connection, String courseID, String courseName, String teacherId) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE course SET ");
        if (courseName != null && !courseName.equals("")) {
            sb.append("courseName=").append("'").append(courseName).append("'");
        }
        if (teacherId != null && !teacherId.equals("")) {
            if (courseName != null && !courseName.equals("")) {
                sb.append(",");
            }
            sb.append("teacherId=").append("'").append(teacherId).append("'");
        }
        sb.append(" WHERE courseId=").append(courseID);

        PreparedStatement pstm = null;
        ResultSet rs = null;
        int execute;
        if (connection != null) {
            Object[] params = {};
            execute = BaseDao.execute(connection, sb.toString(), params, pstm);
            BaseDao.closeResource(null, pstm, rs);
            return execute;
        }
        return 0;
    }

    @Override
    public int delete(Connection connection, String courseID) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int execute;
        if (connection != null) {
            String sql = "DELETE FROM course WHERE courseId=?";
            Object[] params = {courseID};
            execute = BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null, pstm, rs);
            return execute;
        }
        return 0;
    }
}
