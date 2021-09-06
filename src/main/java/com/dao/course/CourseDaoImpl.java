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
        ResultSet rs= null;
        List<course> CourseList = new ArrayList<course>();
        if(connection!=null){
            String sql="select * from course";
            course course = null;
            Object[] params = {};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()) {
                course = new course();
                course.setId(rs.getString("courseId"));
                course.setName(rs.getString("courseName"));
                course.setTeacherId(rs.getString("teacherId"));
                CourseList.add(course);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return CourseList;
    }
}
