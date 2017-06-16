package com.hobo.app.conf;

import com.hobo.security.servlet.CaptchaServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Steven on 2017/3/12.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//        registry.addResourceHandler("/favicon.ico").addResourceLocations("/static/favicon.ico");
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(new WebArgumentResolver());
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LocaleChangeInterceptor());
//    }
//
//    @Bean
//    public LocaleResolver localeResolver() {
//        return new SessionLocaleResolver();
//    }
//
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
//
//    @Bean(name = "sitemeshFilter")
//    public FilterRegistrationBean sitemeshFilter() {
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//        bean.setFilter(new ConfigurableSiteMeshFilter());
//        bean.addUrlPatterns("/*");
//        bean.addInitParameter("configFile", "/WEB-INF/config/sitemesh/sitemesh.xml");
//        return bean;
//    }

    @Bean(name = "captchaServlet")
    public ServletRegistrationBean captchaServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(new CaptchaServlet());
        bean.addUrlMappings("/captcha");
        return bean;
    }
}
