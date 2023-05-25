package com.byelblog.config;

import com.byelblog.common.result.Const;
import com.byelblog.utils.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI(); // 获取请求的URI，例如："/api/example"

        if(uri.matches(Const.NO_INTERCEPTOR_PATH)){
            return  true;
        }
        System.out.println("当前路径："+uri);
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        String token = request.getHeader("token");
        if(!TokenUtil.verify(token)){
            throw new RuntimeException("no login");
        }else {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
