package com.sangeng.interceptor;

import com.sangeng.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中的token
        String token = request.getHeader("token");

        if (!StringUtils.hasText(token)) {
            // response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            throw new RuntimeException("未登录");
             // return false; // 是否放行，不放行，拦截，不允许请求对应的handle方法
        }

        try {
            Claims claims = JwtUtil.parseJWT(token);
            System.out.println(claims.getSubject());
        } catch (Exception e) {
            e.printStackTrace();
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
            throw new RuntimeException("未登录");
        }

        return true;
    }
}
