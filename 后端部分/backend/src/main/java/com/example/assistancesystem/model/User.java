package com.example.assistancesystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    @Size(min=5,max=16,message="密码的长度5-16位")
    private String password;

    @Column(name = "uid",nullable = false)
    private int uid;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "post")
    private String post;

    @Column(name = "classes")
    private String classes;

    @Column(name = "tel")
    private String tel;

    @Column(name = "qq")
    private String qq;

    @Column(name = "num")
    private String num;

    @Column(name = "power")
    private String power = "1";


    public User(){}

    public User(String username,String password){
        this.username = username;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPower() {
        return power;
    }
}
