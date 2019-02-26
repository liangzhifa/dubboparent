package com.ts.model;

import java.io.Serializable;

public class User implements Serializable{
    private Integer id;

    private String username;

    private String identification;

    private String password;

    private Short sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public User() {
    }

    public User(String username, String identification, String password, Short sex) {
        this.username = username;
        this.identification = identification;
        this.password = password;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", identification='" + identification + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                '}';
    }
}