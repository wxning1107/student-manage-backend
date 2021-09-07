package com.dao.Student;

import com.dao.BaseDao;
import com.pojo.grade;
import com.pojo.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<grade> search(Connection connection, String studentId) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        List<grade> GradeList = new ArrayList<grade>();
        if(connection!=null){
            String sql="select grade.teacherId,grade.studentId,grade.courseId,grade,course.courseName,student.studentName,student.major,student.Class1" +
                    " from grade,course,student where grade.courseId=course.courseId and student.studentId=grade.studentId and grade.studentId=?";
            grade grade1 = null;
            Object[] params = {studentId};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()) {
                grade1 = new grade();
                grade1.setTeacherId(rs.getString("teacherId"));
                grade1.setStudentId(rs.getString("studentId"));
                grade1.setCourseId(rs.getString("courseId"));
                grade1.setGrade1(rs.getInt("grade"));
                grade1.setCourseName(rs.getString("courseName"));
                grade1.setStudentName(rs.getString("studentName"));
                grade1.setMajor(rs.getString("major"));
                grade1.setClass1(rs.getString("Class1"));
                GradeList.add(grade1);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return GradeList;
    }

    @Override
    public student getLogin(Connection connection, String studentId) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        student student=null;

        if(connection!=null){
            String sql="select * from student where studentId=?";
            Object[] params = {studentId};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            if(rs.next()) {
                student = new student();
                student.setStudentId(rs.getString("studentId"));
                student.setStudentName(rs.getString("studentName"));
                student.setStudentSex(rs.getString("studentSex"));
                student.setMajor(rs.getString("major"));
                student.setClass(rs.getString("Class1"));
                student.setPassword(rs.getString("password"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return student;
    }

    @Override
    public List<String> getAllClasses(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        List<String> classList = new ArrayList<String>();
        if(connection != null){
            String sql="select distinct `Class1` from student";
            Object[] params = {};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()) {
                classList.add(rs.getString("Class1"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return classList;
    }

    @Override
    public List<String> getAllMajors(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        List<String> classList = new ArrayList<String>();
        if(connection != null){
            String sql="select distinct `major` from student";
            Object[] params = {};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()) {
                classList.add(rs.getString("major"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return classList;
    }
}
