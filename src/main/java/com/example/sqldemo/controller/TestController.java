package com.example.sqldemo.controller;

import com.example.sqldemo.DataTest.DataTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String say(){
        DataTest a = new DataTest();
        a.main();
        return "a";
    };

}
