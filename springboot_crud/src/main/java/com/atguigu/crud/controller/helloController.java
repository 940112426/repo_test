package com.atguigu.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author XuMingyue
 * @create 2020-04-12 17:19
 */
@Controller
public class helloController {
    @RequestMapping({"/","index"})
    public String hello(){

        return "index";
    }
//    //进入首页
//    @RequestMapping("index")
//    public String index(){
//        return "index";
//    }

}
