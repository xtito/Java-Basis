package com.xtito.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by [Zy]
 * 2017/10/9 15:18
 */
@Controller
@RequestMapping("/loginCtrl")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        System.out.println("进来了");
        return "login";
    }


}
