package com.atguigu.crud.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author XuMingyue
 * @create 2020-04-13 14:56
 * 登录检查
 */
public class LogignHanderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //得到session中的用户信息
        Object user = request.getSession().getAttribute("loginUser");
        if(user == null){
            //未登录返回登录界面
            request.setAttribute("msg","没有权限先登录");
            request.getRequestDispatcher("/atguigu").forward(request,response);
            return false;
        }else{
            //已经登录,放行
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
