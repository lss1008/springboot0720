package com.sangeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//controller要在启动类所在的包或其子包下
@Controller
@ResponseBody
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "HelloSpringBoot~";
    }
}
