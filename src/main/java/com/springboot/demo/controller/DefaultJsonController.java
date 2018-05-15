package com.springboot.demo.controller;

import com.springboot.demo.entity.Parent;
import com.springboot.demo.entity.Son;
import com.springboot.demo.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DefaultJsonController {

    @PostMapping("/getOneUser")
    private User getOneUser(){
        User user = new User("张三",17);
        return user;
    }

    @PostMapping("/getParent")
    private Parent getParent(){
        Son son1 = new Son("张三",17);
        Son son2 = new Son("张四",17);
        List<Son> list = new ArrayList<>();
        list.add(son1);list.add(son2);
        Parent parent = new Parent("张三张四的爸爸",124);
        parent.setSons(list);
        return parent;
    }

    @PostMapping("/getParam")
    private User getParam(@RequestBody @Validated User user, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            List<ObjectError> list = bindingResult.getAllErrors();
            for(ObjectError objectError:list){
                //当拦截到校验异常时可以返回我们给定的格式
                System.out.println(objectError.getCode()+"-"+objectError.getDefaultMessage());
                throw new Exception(objectError.getCode()+"-"+objectError.getDefaultMessage());
            }
        }
        return user;
    }
}
