package com.service.Admin;

import com.dao.Admin.Admindao;
import com.dao.Admin.AdmindaoImpl;
import com.dao.BaseDao;
import com.pojo.admin;
import com.pojo.student;
import com.pojo.teacher;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AdminServiceImpl implements AdminService{

    private Admindao admindao;
    public AdminServiceImpl(){
        admindao = new AdmindaoImpl();
    }

    @Override
    public admin getLogin(String adminCode) throws SQLException {
        Connection connection=null;
        admin admin=null;
        connection=BaseDao.getConnection();
        admin=admindao.getLogin(connection,adminCode);
        return admin;
    }

    @Override
    public int addstudent(String studentId, String studentName, String studentSex, String major, String Class1,String password) {
        Connection connection = null;
        int addInfo = 0;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体数据库操作
            addInfo = admindao.addstudent(connection,studentId, studentName, studentSex, major, Class1,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return addInfo;
    }

    @Override
    public int addteacher(String teacherId, String teacherName, String teacherSex, String major, String password) {
        Connection connection = null;
        int addInfo = 0;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体数据库操作
            addInfo = admindao.addteacher(connection,teacherId, teacherName,teacherSex, major,  password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return addInfo;

    }

    @Override
    public int addcourse(String classId, String className, String teacherId) {
        Connection connection = null;
        int addInfo = 0;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体数据库操作
            addInfo = admindao.addcourse(connection,classId,className,teacherId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return addInfo;
    }

    @Override
    public int addgrade(String teacherId, String studentId, String courseId, int grade) {
        Connection connection = null;
        int addInfo = 0;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体数据库操作
            addInfo = admindao.addgrade(connection,teacherId,studentId,courseId,grade);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return addInfo;
    }

    @Override
    public int deleteStudent(String studentId) throws SQLException {
        Connection connection=null;
        connection=BaseDao.getConnection();
        int result = 0;
        result=admindao.deleteStudent(connection,studentId);

        if(result!=0){
            return result;
        }
        return 0;
    }

    @Override
    public int deleteTeacher(String teacherId) throws SQLException {
        Connection connection=null;
        connection=BaseDao.getConnection();
        int result = 0;
        result=admindao.deleteTeacher(connection,teacherId);

        if(result!=0){
            return result;
        }
        return 0;
    }

    @Override
    public int deleteCourse(String courseId) throws SQLException {
        Connection connection=null;
        connection=BaseDao.getConnection();
        int result = 0;
        result=admindao.deleteCourse(connection,courseId);

        if(result!=0){
            return result;
        }
        return 0;
    }

    @Override
    public List<admin> search() {
        Connection connection=null;
        List<admin> admins = null;
        try {
            admins = admindao.search(BaseDao.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return admins;
    }

    @Test
    public void test()throws SQLException{
        AdminServiceImpl billService= new AdminServiceImpl();
        //int n=billService.addgrade("001","3003","101",65);
        //int m=billService.deleteCourse("555");
        Connection connection=BaseDao.getConnection();
        admin admin=admindao.getLogin(connection,"123456");
        System.out.println(admin.getName()+" "+admin.getPassword());

    }

}
