package com.dao.Admin;

import com.dao.BaseDao;
import com.pojo.admin;
import com.pojo.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmindaoImpl implements Admindao{

    @Override
    public admin getLogin(Connection connection, String adminCode) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        admin admin=null;

        if(connection!=null){
            String sql="select * from admin where adminCode=?";
            Object[] params = {adminCode};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            if(rs.next()) {
                admin = new admin();
                admin.setAdminCode(rs.getString("adminCode"));
                admin.setPassword(rs.getString("password"));
                admin.setName(rs.getString("name"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return admin;
    }

    @Override
    public int addstudent(Connection connection, String studentId, String studentName, String studentSex, String major, String Class1,String password)throws SQLException{
        PreparedStatement pstm = null;
        ResultSet rs= null;
        int execute=1;
        connection=BaseDao.getConnection();
        if(connection!=null){
            String sql="insert into student values (?,?,?,?,?,?);";
            Object[] params = {studentId, studentName, studentSex, major, Class1,password};
            execute =  BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null,pstm,rs);
        }
        return execute;
    }

    @Override
    public int addteacher(Connection connection, String teacherId, String teacherName, String teacherSex, String major, String password) throws SQLException{
        PreparedStatement pstm = null;
        ResultSet rs= null;
        int execute=0;
        if(connection!=null){
            String sql="insert into teacher values (?,?,?,?,?);";
            Object[] params = {teacherId, teacherName, teacherSex, major, password};
            execute =  BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null,pstm,rs);
            return execute;
        }
        return 0;
    }

    @Override
    public int addcourse(Connection connection, String classId, String className, String teacherId)throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        int execute=0;
        if(connection!=null){
            String sql="insert into course values (?,?,?);";
            Object[] params = {classId, className, teacherId};
            execute =  BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null,pstm,rs);
            return execute;
        }
        return 0;
    }

    @Override
    public int addgrade(Connection connection, String teacherId, String studentId, String courseId, int grade) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        int execute=0;
        if(connection!=null){
            String sql="insert into grade values (?,?,?,?);";
            Object[] params = {teacherId,studentId,courseId,grade};
            execute =  BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null,pstm,rs);
            return execute;
        }
        return 0;
    }

    @Override
    public int deleteStudent(Connection connection, String studentId) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        if(connection!=null){
            String sql="delete from student where studentId=?";
            Object[] params = {studentId};
            int execute = BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null,pstm,rs);
            return execute;
        }
        return 0;
    }

    @Override
    public int deleteTeacher(Connection connection, String teacherId) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        if(connection!=null){
            String sql="delete from teacher where teacherId=?";
            Object[] params = {teacherId};
            int execute = BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null,pstm,rs);
            return execute;
        }
        return 0;
    }

    @Override
    public int deleteCourse(Connection connection, String courseId) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs= null;
        if(connection!=null){
            String sql="delete from course where courseId=?";
            Object[] params = {courseId};
            int execute = BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null,pstm,rs);
            return execute;
        }
        return 0;
    }
}
