package com.springboot.demo.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Son extends User {

    public Son() {

    }

    public Son(@NotEmpty String userName, @Min(value = 18, message = "未满十八岁") @Max(value = 120, message = "该死了") Integer age) {
        super(userName, age);
    }
}
