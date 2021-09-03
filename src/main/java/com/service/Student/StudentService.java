package com.service.Student;

import com.pojo.grade;
import com.pojo.student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    public List<grade> search(String studentId);
    public student getLogin(String studentId)throws SQLException;
}
