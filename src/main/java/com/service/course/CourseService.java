package com.service.course;

import com.pojo.course;

import java.util.List;

public interface CourseService {
    public List<course> search();
    public int add(String courseID, String courseName, String teacherID);
    public int update(String courseID, String courseName, String teacherID);
    public int delete(String courseID);
}
