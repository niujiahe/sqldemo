package com.example.sqldemo.controller;

import com.example.sqldemo.DataTest.DataTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChartController {
    /**
      * @Author 牛家禾
      * @Date 2017/10/31 10:06
      * @Description 绘图功能
      */
    @RequestMapping(value = "/chart",method = RequestMethod.GET)
    public String hello(Model model) {
        DataTest test = new DataTest();
        String dataget = test.getandSort(201704);
        model.addAttribute("dataget",dataget);
        return "HighchartsTest";
    }
    /**
      * @Author 牛家禾
      * @Date 2017/10/31 14:15
      * @Description 所有数据绘图
      */
    @RequestMapping(value = "/chartall",method = RequestMethod.GET)
    public String hello2(Model model2) {
        DataTest test = new DataTest();
        String dataget = test.findAll();
        model2.addAttribute("dataget",dataget);
        return "HighchartsAll";
    }
}
