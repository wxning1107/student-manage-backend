package com.dao.Teacher;

import com.dao.BaseDao;
import com.pojo.grade;
import com.pojo.student;
import com.pojo.teacher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    @Override
    public teacher getLogin(Connection connection, String teacherId) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        teacher teacher=null;
        if(connection!=null){
            String sql="select * from teacher where teacherId=?";
            Object[] params = {teacherId};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            if(rs.next()) {
                teacher = new teacher();
                teacher.setTeacherId(rs.getString("teacherId"));
                teacher.setTeacherName(rs.getString("teacherName"));
                teacher.setTeacherSex(rs.getString("teacherSex"));
                teacher.setMajor(rs.getString("major"));
                teacher.setPassword(rs.getString("password"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return teacher;
    }

    @Override
    public int update(Connection connection, String teacherId, String studentId, String courseId,int grade) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        int execute=0;
        if(connection!=null){
            String sql="update grade set grade=? where studentId=? and courseId=? and teacherId=?";
            Object[] params = {grade,studentId,courseId,teacherId};
            execute =  BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null,pstm,rs);
            return execute;
        }
        return 0;
    }

    @Override
    public List<grade> search(Connection connection, String teacherId, String courseId) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        List<grade> GradeList = new ArrayList<grade>();
        if(connection!=null){
            String sql="select grade.teacherId,grade.studentId,grade.courseId,grade,course.courseName,student.studentName,student.major,student.Class1" +
                    " from grade,course,student where grade.courseId=course.courseId and student.studentId=grade.studentId and grade.teacherId=?" +
                    "and grade.courseId=?";
            grade grade1 = null;
            Object[] params = {teacherId,courseId};
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
    public List<grade> search(Connection connection, String teacherId, String courseId, String major) throws SQLException{
        PreparedStatement pstm = null;
        ResultSet rs= null;
        List<grade> GradeList = new ArrayList<grade>();
        if(connection!=null){
            String sql="select grade.teacherId,grade.studentId,grade.courseId,grade,course.courseName,student.studentName,student.major,student.Class1" +
                    " from grade,course,student where grade.courseId=course.courseId and student.studentId=grade.studentId and grade.teacherId=?" +
                    "and grade.courseId=? and student.major=?";
            grade grade1 = null;
            Object[] params = {teacherId,courseId,major};
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
    public List<grade> search(Connection connection, String teacherId, String courseId, String major, String Class1)throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        List<grade> GradeList = new ArrayList<grade>();
        if(connection!=null){
            String sql="select grade.teacherId,grade.studentId,grade.courseId,grade,course.courseName,student.studentName,student.major,student.Class1" +
                    " from grade,course,student where grade.courseId=course.courseId and student.studentId=grade.studentId and grade.teacherId=?" +
                    "and grade.courseId=? and student.major=? and student.Class1=?";
            grade grade1 = null;
            Object[] params = {teacherId,courseId,major,Class1};
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
}
