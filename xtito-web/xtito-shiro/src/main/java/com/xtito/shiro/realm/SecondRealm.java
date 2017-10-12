package com.xtito.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * 多 Realm
 * 使用 SHA1 加密
 *
 * 认证策略：
 *  FirstSuccessfulStrategy 只要有一个 Realm 验证成功即可，返回一个 Realm 身份认证成功的认证信息
 *  AtLeastOneSuccessfulStrategy 只要有一个 Realm 验证成功即可，返回所有认证信息(默认策略)
 *  AllSuccessfulStrategy 所有 Realm 验证成功才算成功，且返回所有认证信息，如果有一个失败就失败了
 *
 * Created by [Zy]
 * 2017/10/9 17:42
 */
public class SecondRealm extends AuthenticatingRealm {

    /**
     * 用于认证的方法
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("[SecondRealm] doGetAuthenticationInfo");

        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        //2. 从 UsernamePasswordToken 中来获取 username
        String username = upToken.getUsername();

        //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
        System.out.println("从数据库中获取 username: " + username + " 所对应的用户信息.");

        //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
        if("unknown".equals(username)){
            throw new UnknownAccountException("用户不存在!");
        }

        //5. 根据用户信息的情况, 决定是否需要抛出其他的 AuthenticationException 异常.
        if("monster".equals(username)){
            throw new LockedAccountException("用户被锁定");
        }

        //6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        //以下信息是从数据库中获取的.
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        Object principal = username;
        //2). credentials: 密码. 数据库查询的密码
        Object credentials = "123456"; //"fc1709d0a95a6be30bc5926fdb7f22f4";

        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        String realmName = getName();


        //4). 盐值.实现不同用户同样的密码结果也不同
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);

        if ("admin".equals(username)) {
            credentials = "ce2f6417c7e1d32c1d81a797ee0b499f87c5de06";
        } else if ("user".equals(username)) {
            credentials = "073d4c3ae812935f23cb3f2a71943f49e082a718";
        }

        return new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
    }
}