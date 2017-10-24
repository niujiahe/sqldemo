package com.example.sqldemo.controller;

import com.example.sqldemo.DataTest.DataTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String say(){
        DataTest test = new DataTest();
        return test.main();
    };

}
