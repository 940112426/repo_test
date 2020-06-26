package com.atguigu.crud.config;

import com.atguigu.crud.component.LogignHanderInterceptor;
import com.atguigu.crud.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author XuMingyue
 * @create 2020-04-12 18:21
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        //通过访问atguigu进入index页面
        registry.addViewController("atguigu").setViewName("index");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurer adapter=new WebMvcConfigurerAdapter() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //登录拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                /**
                 * addPathPatterns("/**")拦截所有的访问路径
                 *   excludePathPatterns("/",    访问登录页面
                 *                       "auguigu", 访问登录页面
                 *                      "/user/login" 登录跳转页面
                 *                      );
                 */

                registry.addInterceptor(new LogignHanderInterceptor()).addPathPatterns("/**").
                        excludePathPatterns("/","/atguigu","/user/login");
            }
        };
        return (WebMvcConfigurerAdapter) adapter;
    }


    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

}

