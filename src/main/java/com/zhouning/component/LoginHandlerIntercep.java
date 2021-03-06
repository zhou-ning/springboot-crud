package com.zhouning.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * @author zhouning
 */
public class LoginHandlerIntercep implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user==null){
            //未登录，返回登录页面
            request.setAttribute("msg", "请先登录");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }else {
            //进行了登录
            return true;
        }
    }
}
