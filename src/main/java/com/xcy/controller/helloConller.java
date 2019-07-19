package com.xcy.controller;

import com.xcy.pojo.User;
import com.xcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class helloConller {
    @Value("${name}")
    String name;

    @Value("${person.name}")
    String name2;

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    public String show(){

        System.out.println(name+"3333333333");
        System.out.println(name2+"222222222222");

        //userService.getAllUser();
        return "hello word，55";
    }

    @RequestMapping("/hello222")
    @ResponseBody
    public List<User> showUser(){
        return  userService.getAllUser();
        //return "hello word，55";
    }
}
