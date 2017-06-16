package com.hobo.security.filter;

import com.hobo.security.SecurityToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SsoAuthFilter extends FormAuthenticationFilter {
    public static final String DEFAULT_USERNAME_PARAM = "username";

    private String usernameParam = DEFAULT_USERNAME_PARAM;

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        SecurityToken token = createToken(request, response);
        if (token == null) {
            throw new IllegalStateException("token cannot be null.");
        }

        try {
            // 验证Referer是否是可信域
            doRefererValidate((HttpServletRequest) request, token);

            Subject subject = getSubject(request, response);
            subject.login(token);
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            return executeLogin(request, response);
        } else {
            saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }

    @Override
    protected SecurityToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String referer = getReferer(request);

        return SecurityToken.createSsoToken(username, referer);
    }

    // Referer检验
    protected void doRefererValidate(HttpServletRequest request, SecurityToken token) {
    }

    protected String getUsername(ServletRequest request) {
        return WebUtils.getCleanParam(request, getUsernameParam());
    }

    protected String getReferer(ServletRequest request) {
        return WebUtils.getCleanParam(request, getUsernameParam());
    }

    public String getUsernameParam() {
        return usernameParam;
    }

    public void setUsernameParam(String usernameParam) {
        this.usernameParam = usernameParam;
    }
}
