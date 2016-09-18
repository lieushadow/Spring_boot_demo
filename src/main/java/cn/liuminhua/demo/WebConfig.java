package cn.liuminhua.demo;

import cn.liuminhua.demo.filter.LoginInterceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 敏华 on 2016-09-18.
 */

@Component
public class WebConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor());
        super.addInterceptors(registry);
    }
}
