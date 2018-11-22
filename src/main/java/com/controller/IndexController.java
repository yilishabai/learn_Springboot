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

    @RequestMapping(method = RequestMethod.POST)//获取user信息返回user信息
    public String add(@RequestBody JSONObject text){
        User user = null;
        System.out.println(text.toJSONString());
        String name = text.getString("nickName");
        String openid = text.getString("openid");
        int dayNum = text.getIntValue("dayNum");
        if(name!=null&&openid!=null) {//如果名字和openid不为空
            user = userService.get(openid);//看看能不能获取这个用户
            if(user==null) {//说明数据库里没有该用户
                if (dayNum != 0) {
                    user = new User(name, dayNum, openid);//创建用户
                } else {
                    user = new User(name, openid);//创建用户
                }
                userService.add(user);//插入数据库
            }
        }else{
            return "failed";
        }
//        System.out.println(user);
        return JSON.toJSONString(user);//返回user
    }

    @RequestMapping(method = RequestMethod.PUT)//更新每日单词量
    public String setDayNum(@RequestBody JSONObject text){
        int dayNum = text.getIntValue("dayNum");
        int id = text.getIntValue("id");
        String openid = text.getString("openid");
        System.out.println(dayNum);
        System.out.println(id);
        System.out.println(openid);
        User user = userService.get(id);
        if(user.getOpenid().equals(openid)){//简单校验
            user.setDayNum(dayNum);//更新每日单词量
            userService.update(user);//更新数据库
        }
        return "OK";
    }
}
