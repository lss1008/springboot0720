package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.User;
import com.sangeng.resolver.CurrentUserId;
import com.sangeng.service.UserService;
import com.sangeng.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ResponseResult findAll(@CurrentUserId String userId) throws Exception {
//        String token = request.getHeader("token");
//        if (StringUtils.hasText(token)) {
//            Claims claims = JwtUtil.parseJWT(token);
//            String useId = claims.getSubject();
//            System.out.println(useId);
//
//        }
        System.out.println(userId);
        List<User> users = userService.findAll();

        return new ResponseResult(200, users);
    }


}
