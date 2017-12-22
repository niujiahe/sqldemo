package com.Order_simulation_statistics.controller;

import com.Order_simulation_statistics.Service.OrdersService;
import com.Order_simulation_statistics.entity.Orders;
import com.Order_simulation_statistics.entity.sys_statistics_summaryInfo;
import com.Order_simulation_statistics.mapper.OrdersRepository;
import com.Order_simulation_statistics.mapper.RuleRepository;
import com.Order_simulation_statistics.mapper.SummaryRepository;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ChartController {
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrdersService ordersService;
    @Autowired
    SummaryRepository summaryRepository;
    @Autowired
    RuleRepository ruleRepository;

    /**
      * @Author 牛家禾
      * @Date 2017/10/31 10:06
      * @Description 绘图功能
      */
    @RequestMapping(value = "/chart",method = RequestMethod.GET)
    public String hello(Model model) {
        List<sys_statistics_summaryInfo> dataget = summaryRepository.findAll();
        String dataget1 = JSONArray.fromObject(dataget).toString();
        model.addAttribute("dataget",dataget1);

        List<Integer> AllRuleid = ruleRepository.getAllRuleid();
        JSONArray json1 = JSONArray.fromObject(AllRuleid);
        String ruleAll = json1.toString();
        model.addAttribute("ruleAll",ruleAll);

        return "HighchartsTest";
    }
    /**
      * @Author 牛家禾
      * @Date 2017/10/31 14:15
      * @Description 所有数据绘图
      */
    @RequestMapping(value = "/chartall",method = RequestMethod.GET)
    public String hello2(Model model2) {
        List<Orders> dataget = ordersRepository.findAll();
        JSONArray json = JSONArray.fromObject(dataget);
        String datagetall = json.toString();

        model2.addAttribute("dataget",datagetall);
        return "HighchartsAll";
    }
    /**
      * @Author 牛家禾
      * @Date 2017/11/28 10:35
      * @Description 测试主界面
      */
    @RequestMapping(value = "/testui",method = RequestMethod.GET)
    public String testui(){
        return "testui";
    }

    /**
      * @Author 牛家禾
      * @Date 2017/11/28 15:19
      * @Description 规则添加界面
      */
    @RequestMapping(value = "/newrule",method = RequestMethod.GET)
    public String newrule(){
        return "newrule";
    }

}
