package com.hobo.app.web;

import com.hobo.security.SecurityUtils;
import com.hobo.security.exception.IncorrectCaptchaException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Steven on 2017/3/8.
 */
@Controller("WebAuthController")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) {
        logger.info("login post ......");
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
        return "login";
    }

    @RequestMapping(value = "/unauthorized")
    public String unauthorized() {
        logger.info("login post ......");
        return "unauthorized";
    }

    private String parseException(HttpServletRequest request) {
        String errorClassName = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);

        String msg = null;
        if (IncorrectCaptchaException.class.getName().equals(errorClassName)) {
            msg = "The verification code is incorrect.";
        } else if (UnknownAccountException.class.getName().equals(errorClassName)) {
            msg = "Username or password is incorrect.";
        } else if (IncorrectCredentialsException.class.getName().equals(errorClassName)) {
            msg = "Username or password is incorrect.";
        } else if (AuthenticationException.class.getName().equals(errorClassName)) {
            msg = "Username or password is incorrect.";
        } else if (DisabledAccountException.class.getName().equals(errorClassName)) {
            msg = "Username or password is incorrect.";
        } else {
            msg = "Username or password is incorrect.";
        }
        return msg;
    }

    @RequestMapping(value = "/logout")
    public String logout(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username, HttpServletRequest request, Model model) {
        logger.info("logout ......");
        SecurityUtils.getSubject().logout();
        return "login";
    }
}
