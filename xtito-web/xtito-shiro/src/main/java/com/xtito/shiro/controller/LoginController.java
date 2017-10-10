package com.xtito.shiro.controller;

import com.xtito.shiro.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by [Zy]
 * 2017/10/9 15:18
 */
@Controller
@RequestMapping("/loginCtrl")
public class LoginController {

    @Autowired()
    private ShiroService shiroService;

    @RequiresRoles({"admin"})
    @RequestMapping("/testShiroAnnotation")
    public String testShiroAnnotation(HttpSession session){
        session.setAttribute("key", "value12345");
        shiroService.testMethod();
        return "redirect:/jsp/list.jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {

        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd);
            // rememberme
            token.setRememberMe(true);
            try {
                System.out.println("1、token hashCode: " + token.hashCode());
                // 执行登录.
                currentUser.login(token);
            } catch (AuthenticationException ae) {
                //unexpected condition?  error?
                System.out.println("登录失败： " + ae.getMessage());
            }
        }

        return "redirect:/jsp/list.jsp";
    }


}
