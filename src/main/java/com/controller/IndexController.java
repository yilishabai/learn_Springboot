package com.controller;

import com.alibaba.fastjson.JSON;
import com.model.User;
import com.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestParam(required = true) String name, @RequestParam(required = true) Integer age){
        User user = new User(name, age);
        User get = userService.add(user);
        get.setName("asdasd");
        userService.add(get);
        return JSON.toJSONString(get);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(@RequestParam(required = true) Integer sid){
        User user = userService.get(sid);
        return JSON.toJSONString(user);
    }


    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public String getAll(){
        List<User> all = userService.findAll();
        return JSON.toJSONString(all);
    }

    @RequestMapping(value = "/getByAge",method = RequestMethod.GET)
    public String getByAge(int age){
        List<User> all = userService.findUsersByAge(age);
        return JSON.toJSONString(all);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(Integer sid){
        userService.remove(sid);
        return "success";
    }





}
