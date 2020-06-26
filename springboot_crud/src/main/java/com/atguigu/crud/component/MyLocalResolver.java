package com.atguigu.crud.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author XuMingyue
 * @create 2020-04-13 13:58
 * 在链接上携带区域信息
 */
public class MyLocalResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取参数l的值
        String l = request.getParameter("l");
        //操作系统默认的语言
        Locale locale=Locale.getDefault();
        //判断参数是否为空
        if(!StringUtils.isEmpty(l)){
            //分割字符串
            String[] split = l.split("_");
            locale=new Locale(split[0],split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
