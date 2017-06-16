package com.hobo.security;

import org.apache.shiro.authc.UsernamePasswordToken;

public class SecurityToken extends UsernamePasswordToken {
    // 验证码
    private String captcha;

    // Referer
    private String referer;

    // 登录类型
    private String type;

    public SecurityToken() {
        super();
    }

    public SecurityToken(String username, String password) {
        super(username, password);
    }

    public static SecurityToken createSsoToken(String username, String referer) {
        SecurityToken token = new SecurityToken(username, null);
        token.setType(SecurityConstants.AUTH_TYPE_SSO);
        token.setReferer(referer);
        return token;
    }

    public static SecurityToken createApiToken(String username, String password, String token) {
        SecurityToken securityToken = new SecurityToken(username, password);
        securityToken.setType(SecurityConstants.AUTH_TYPE_API);
        return securityToken;
    }

    public static SecurityToken createFormToken(String username, String password, String captcha, String host, boolean rememberMe) {
        SecurityToken token = new SecurityToken(username, password);
        token.setType(SecurityConstants.AUTH_TYPE_FORM);
        token.setCaptcha(captcha);
        token.setHost(host);
        token.setRememberMe(rememberMe);
        return token;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
