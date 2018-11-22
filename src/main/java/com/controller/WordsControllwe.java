package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.model.Book;
import com.model.User;
import com.model.Word;
import com.sevice.BookService;
import com.sevice.UserService;
import com.sevice.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/words")
public class WordsControllwe {
    @Autowired
    private WordService wordService;
    @Autowired
    private BookService BookService;
    @Autowired
    private UserService userService;
//    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
//    public String getAllWords(){
//        List<Word> all = wordService.findAll();
//        return JSON.toJSONString(all);
//    }

    @RequestMapping(value = "/learned",method = RequestMethod.POST)
    public String updateLearned(@RequestBody JSONObject data){
        System.out.println(data);
        return "post learned ok!";
    }

    @RequestMapping(value = "/getDayWords", method = RequestMethod.GET)
    public List<Word> get(@RequestParam(required = true) int id){//获取每日单词数量的单词
        User user = userService.get(id);
        if(user!=null) {
            List<Word> wordList = wordService.getWordDaynum(user.getDayNum());
            return wordList;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/getBooks",method = RequestMethod.GET)
    public String getAllBooks(){
        List<Book> all = BookService.findAll();
        return JSON.toJSONString(all);
    }
}
