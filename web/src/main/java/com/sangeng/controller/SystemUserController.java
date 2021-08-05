package com.sangeng.controller;


import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.SystemUser;
import com.sangeng.service.SystemUserService;
import com.sangeng.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/sys_user")
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody SystemUser user) {
        Map<String, Object> map = new HashMap<>();
        SystemUser loginUser = systemUserService.login(user);
        if (loginUser != null) {
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(loginUser.getId()), null);
            map.put("token", token);
        } else {
            return new ResponseResult(300, "用户名或密码错误");
        }
        return new ResponseResult(200, "登录成功!!!", map);
    }
}
