package com.hobo.app.web;

import com.hobo.security.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Steven on 2017/3/12.
 */
@Controller("WebIndexController")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        String username = SecurityUtils.getUsername();
        boolean isAuth = SecurityUtils.isAuthenticated();
        model.addAttribute("name", username);
        model.addAttribute("isAuth", isAuth);
        return "index";
    }
}
