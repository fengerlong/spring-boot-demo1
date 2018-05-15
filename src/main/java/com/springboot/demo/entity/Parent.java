package com.springboot.demo.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class Parent extends User {

    private List<Son> sons;

    public Parent(List<Son> sons) {
        this.sons = sons;
    }

    public Parent(@NotEmpty String userName, @Min(value = 18, message = "未满十八岁") @Max(value = 120, message = "该死了") Integer age) {
        super(userName, age);
    }

    public List<Son> getSons() {
        return sons;
    }

    public void setSons(List<Son> sons) {
        this.sons = sons;
    }
}
