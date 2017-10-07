package com.xtito.shiro.x02;

import org.apache.shiro.SecurityUtils;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by [Zy]
 * 2017/10/7 14:22
 */
public class TestLoginAndLoginOut {

    public static void main(String[] args) {

        // 构建SecurityManager工厂，IniSecurityManagerFactory可以从ini文件中初始化SecurityManager环境
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 通过工厂创建SecurityManager
        SecurityManager securityManager = factory.getInstance();
        // 将SecurityManager设置到运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        // 创建一个Subject实例，该实例认证需要使用上面创建的SecurityManager
        Subject subject = SecurityUtils.getSubject();
        // 创建token令牌，账号和密码是ini文件中配置的
        AuthenticationToken token = new UsernamePasswordToken("root", "secret");
        try {
            //用户登录
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        //用户认证状态
        Boolean isAuthenticated = subject.isAuthenticated();
        System.out.println("用户认证状态："+isAuthenticated);//输出true

        //用户退出
        subject.logout();

        isAuthenticated = subject.isAuthenticated();
        System.out.println("用户认证状态："+isAuthenticated);//输出false

    }

}
