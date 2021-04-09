package com.example.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.*;


/**
 * 把 Filter 注入springboot容器当中
 */
@Configuration
public class FilterConfig {
    @Bean
    Filter reqResFilter(){
        return new ReqResFilter();
    }

    @Bean
    public FilterRegistrationBean<ReqResFilter> filterRegistrationBean1(){
        FilterRegistrationBean<ReqResFilter> filterRegistrationBean=new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter((ReqResFilter) reqResFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        //filterRegistrationBean.setOrder();多个filter的时候order的数值越小 则优先级越高
        return filterRegistrationBean;
    }
}
