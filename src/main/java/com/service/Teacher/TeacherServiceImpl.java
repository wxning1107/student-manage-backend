package com.service.Teacher;

import com.dao.BaseDao;
import com.dao.Teacher.TeacherDao;
import com.dao.Teacher.TeacherDaoImpl;
import com.pojo.grade;
import com.pojo.student;
import com.pojo.teacher;
import com.service.Admin.AdminServiceImpl;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TeacherServiceImpl implements TeacherService{
    TeacherDao teacherDao;
    public TeacherServiceImpl()
    {
        teacherDao=new TeacherDaoImpl();
    }

    @Override
    public teacher getLogin(String teacherId) throws SQLException {
        Connection connection=null;
        teacher teacher=null;
        connection=BaseDao.getConnection();
        teacher=teacherDao.getLogin(connection,teacherId);
        return teacher;
    }

    @Override
    public int update(String teacherId, String studentId, String courseId, int grade) {
        Connection connection = null;
        int addInfo = 0;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体数据库操作
            addInfo = teacherDao.update(connection,teacherId,studentId,courseId,grade);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return addInfo;
    }

    @Override
    public List<grade> search(String teacherId, String courseId) throws SQLException {
        Connection connection=null;
        List<grade> GradeList = null;
        try {
            connection= BaseDao.getConnection();
            GradeList = teacherDao.search(connection,teacherId,courseId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return GradeList;
    }

    @Override
    public List<grade> search(String teacherId, String courseId, String major) throws SQLException {
        Connection connection=null;
        List<grade> GradeList = null;
        try {
            connection= BaseDao.getConnection();
            GradeList = teacherDao.search(connection,teacherId,courseId,major);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return GradeList;
    }

    @Override
    public List<grade> search(String teacherId, String courseId, String major, String Class1) throws SQLException {
        Connection connection=null;
        List<grade> GradeList = null;
        try {
            connection= BaseDao.getConnection();
            GradeList = teacherDao.search(connection,teacherId,courseId,major,Class1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return GradeList;
    }


    @Test
    public void test()throws SQLException{
        Connection connection=null;
        List<grade> billList = null;
        connection=BaseDao.getConnection();
//        try {
//            int n=teacherDao.update(connection,"001","3003","101",59);
//            billList=teacherDao.search(connection,"001","101","计算机","18-2班");
//       } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        for(grade grade1 : billList){
//            System.out.println(grade1.getTeacherId()+"  "+grade1.getStudentName()+"  "+grade1.getCourseName()+"  "+grade1.getGrade1()+" "+grade1.getMajor()+" "+grade1.getClass1());
//        }
        teacher teacher1=teacherDao.getLogin(connection,"002");
        System.out.println(teacher1.getTeacherName()+" "+teacher1.getPassword());
    }
}
