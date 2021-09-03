package com.dao.Student;

import com.pojo.grade;
import com.pojo.student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    //查询成绩表的成绩
    public List<grade> search(Connection connection , String studentId)throws SQLException;
    //登录的时候查自己的密码传到servlet验证
    public student getLogin(Connection connection,String studentId)throws SQLException;
}
