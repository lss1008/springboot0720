package com.sangeng.controller;


import com.sangeng.domain.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class TestController {

    @RequestMapping(value = "/test")
    public String test() {
        return "test111";
    }

    @RequestMapping("/getRequestAndResponse")
    public ResponseResult getRequestAndResponse(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        return new ResponseResult(200, "success");
    }

}
