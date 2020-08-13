package com.huawei.entiry;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

public class User {
    @ExcelProperty({"主键"})
    private int id;
    @ExcelProperty({"姓名"})
    private String name;
    @ExcelProperty({"年龄"})
    private int age;
    @ExcelProperty({"生日"})
    private Date birthday;
    @ExcelProperty({"介绍"})
    private String introduce;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
