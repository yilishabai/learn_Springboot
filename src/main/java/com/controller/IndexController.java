package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.model.User;
import com.model.Word;
import com.sevice.UserService;
import com.sevice.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class IndexController {
    @Autowired
    private WordService wordService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public String getAllWords(){
        List<Word> all = wordService.findAll();
        return JSON.toJSONString(all);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody JSONObject text){
        System.out.println(text.toJSONString());
        String name = text.getString("nickName");
        String openid = text.getString("openid");
        System.out.println(name);
        System.out.println(openid);
        User user = new User(name, openid);
        User save = userService.add(user);
        return "post request";
    }

    @RequestMapping(value = "/getDayNum", method = RequestMethod.GET)
    public List<Word> get(int dayNum){//获取每日单词数量的单词
        List<Word> wordList = wordService.getWordDaynum(dayNum);
        return wordList;
    }


}
