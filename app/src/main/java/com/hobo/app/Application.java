package com.hobo.app;

import com.sixt.service.framework.JettyServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableAutoConfiguration    //启用自动配置
@Configuration              //配置控制
@ComponentScan(basePackages = "com.hobo") //组件扫描
@EnableWebMvc
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

    @Autowired
    public static void main(String[] args) {
        new JettyServiceBase();
        SpringApplication.run(Application.class, args);
    }
}