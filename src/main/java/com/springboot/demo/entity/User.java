package com.springboot.demo.entity;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class User {

    @NotEmpty
    private String UserName;

    @Min(value = 18,message = "未满十八岁")
    @Max(value = 120,message = "该死了")
    private Integer age;

    public User() {

    }

    public User(@NotEmpty String userName, @Min(value = 18, message = "未满十八岁") @Max(value = 120, message = "该死了") Integer age) {
        UserName = userName;
        this.age = age;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
