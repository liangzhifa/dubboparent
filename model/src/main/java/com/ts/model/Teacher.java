package com.ts.model;


import java.io.Serializable;

public class Teacher implements Serializable{
    private Integer id;

    private String teacherName;

    private String teacherPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword == null ? null : teacherPassword.trim();
    }

    public Teacher(String teacherName, String teacherPassword) {
        this.teacherName = teacherName;
        this.teacherPassword = teacherPassword;
    }

    public Teacher() {
    }
}