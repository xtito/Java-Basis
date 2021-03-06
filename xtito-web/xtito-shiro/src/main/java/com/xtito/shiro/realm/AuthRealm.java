package com.xtito.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;

/**
 * 可能把加密信息存储在两个不同的服务器，mysql  oracle都有(可以有不同的加密规则)，这时就需要用到多 realm
 *
 * Created by [Zy]
 * 2017/10/9 16:38
 */
public class AuthRealm extends AuthorizingRealm {

    /**
     * 用于认证的方法
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("[FirstRealm] doGetAuthenticationInfo");

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


        SimpleAuthenticationInfo info = null;
//        info = new SimpleAuthenticationInfo(principal, credentials, realmName);

        //4). 盐值.实现不同用户同样的密码结果也不同
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);

        if ("admin".equals(username)) {
            credentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
        } else if ("user".equals(username)) {
            credentials = "098d2c478e9c11555ce2823231e02ec1";
        }

        info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        return info;
    }

    public static void main(String[] args) {
//        String hashAlgorithmName = "MD5";
        String hashAlgorithmName = "MD5";
        Object credentials = "123456";
        // 盐值，一般可以用用户名
        Object salt = ByteSource.Util.bytes("admin");;
        int hashIterations = 1024;

        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }

    /**
     * 用于用户授权的方法
     *
     * 授权会被 shiro 回调的方法
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("------》 开始用户授权......");

        // 1. 从 PrincipalCollection 中来获取登录用户的信息
        Object principal = principals.getPrimaryPrincipal();

        // 2. 利用登录的用户的信息来用户当前用户的角色或权限(可能需要查询数据库)
        Set<String> roles = new HashSet<>();
        roles.add("user");
        if("admin".equals(principal)){
            roles.add("admin");
        }

        // 3. 创建 SimpleAuthorizationInfo, 并设置其 reles 属性.
        // 4. 返回 SimpleAuthorizationInfo 对象.
        return new SimpleAuthorizationInfo(roles);
    }
}
