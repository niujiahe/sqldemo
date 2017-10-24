package com.example.sqldemo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
public class welcomeController {
    //private Logger logger = (Logger) LoggerFactory.getLogger(welcomeController.class);
    /**
     * 测试hello
     * @return
     */
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        return "welcome";
    }

    @RequestMapping(value = "/chart")
    public String hello() {
        return "HighchartsTest";
    }
}
