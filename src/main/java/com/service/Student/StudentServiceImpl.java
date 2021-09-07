package com.service.Student;

import com.dao.BaseDao;
import com.dao.Student.StudentDao;
import com.dao.Student.StudentDaoImpl;
import com.pojo.grade;
import com.pojo.student;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService{

    StudentDao studentDao;
    public StudentServiceImpl(){studentDao = new StudentDaoImpl(); }

    //检索出来后做特别处理
    @Override
    public List<grade> search(String studentId) {
        Connection connection=null;
        List<grade> GradeList = null;
        try {
            connection= BaseDao.getConnection();
            GradeList = studentDao.search(connection,studentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return GradeList;
    }

    @Override
    public student getLogin(String studentId) throws SQLException {
        Connection connection=null;
        student student=null;
        connection=BaseDao.getConnection();
        student=studentDao.getLogin(connection,studentId);
        return student;
    }

    @Override
    public List<String> getAllClasses(){
        Connection connection=null;
        List<String> classes = null;
        try {
            classes = studentDao.getAllClasses(BaseDao.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return classes;
    }

    @Override
    public List<String> getAllMajors() {
        Connection connection=null;
        List<String> classes = null;
        try {
            classes = studentDao.getAllMajors(BaseDao.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return classes;
    }

    @Override
    public List<student> search() {
        Connection connection=null;
        List<student> students = null;
        try {
            students = studentDao.search(BaseDao.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return students;
    }


    @Test
    public void test()throws SQLException{
        Connection connection=null;
        List<grade> billList = null;
        connection=BaseDao.getConnection();
//        try {
//            billList=studentDao.search(connection,"3182082081605");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        for(grade grade1 : billList){
//            System.out.println(grade1.getStudentName()+"  "+grade1.getCourseName()+"  "+grade1.getGrade1());
//        }
        student student1=studentDao.getLogin(connection,"3002");
        System.out.println(student1.getStudentName()+" "+student1.getPassword());
    }
}
