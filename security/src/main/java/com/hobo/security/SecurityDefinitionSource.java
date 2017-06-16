package com.hobo.security;

import org.apache.shiro.config.Ini;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Steven on 2017/3/7.
 */
public class SecurityDefinitionSource implements FactoryBean<Ini.Section> {
    private static Logger logger = LoggerFactory.getLogger(SecurityDefinitionSource.class);

    @Override
    public Ini.Section getObject() throws Exception {
        return loadSection();
    }

    @Override
    public Class<?> getObjectType() {
        return this.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * 重新加载配置文件
     */
    public void reloadSecuritySection() {

    }

    private Ini.Section loadSection() {
        Ini ini = Ini.fromResourcePath("classpath:shiro.ini");
        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        return section;
    }
}

