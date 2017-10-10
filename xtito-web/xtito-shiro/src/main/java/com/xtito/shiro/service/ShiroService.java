package com.xtito.shiro.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by [Zy]
 * 2017/10/10 15:43
 */
@Service
@Transactional// 如果加上事务，则@RequiresRoles失效，需要将@RequiresRoles放到Controller层
public class ShiroService {

    // 对于抛出的异常，可以使用Spring的声明式异常处理跳转错误页面，防止500
//    @RequiresRoles({"admin"})
    public void testMethod(){
        System.out.println("testMethod, time: " + new Date());

        Session session = SecurityUtils.getSubject().getSession();
        Object val = session.getAttribute("key");

        System.out.println("Service SessionVal: " + val);
    }

}
