package com.pojo;

public class student {
    private String studentId;//学号
    private String studentName;//姓名
    private String studentSex;//性别
    private String major;//专业
    private String Class1;//班级
    private String password;//密码
    private Integer level; // 身份

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentCode) {
        this.studentId = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String sex) {
        this.studentSex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClass1() {
        return Class1;
    }

    public void setClass(String aClass) {
        Class1 = aClass;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}

