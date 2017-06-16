package com.hobo.app.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Steven on 2017/6/14.
 */
@RestController("RestIndexController")
@RequestMapping("/api")
public class IndexController {
    @RequestMapping
    public String idnex() {
        return "api index";
    }
}
