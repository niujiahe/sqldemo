package com.example.sqldemo.controller;

import com.example.sqldemo.PersonProperties;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class helloController {


    @Autowired
    private PersonProperties personProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return personProperties.getName()+personProperties.getAge();
    }

    @RequestMapping("/hello2")
    public String helloHtml(){
        //public String helloHtml(HashMap<String,Object> map){
        //map.put("hello","hello");
        return"/hello2";
    }
}