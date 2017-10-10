package com.xtito.shiro.factory;

import java.util.LinkedHashMap;

/**
 * Created by [Zy]
 * 2017/10/10 16:10
 */
public class FilterChainDefinitionMapBuilder {


    public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {

        // 必须是按顺序的
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        map.put("/static/**", "anon");
        map.put("/login.jsp", "anon");
        map.put("/index.jsp", "anon");
        map.put("/loginCtrl/login", "anon");
        map.put("/loginCtrl/loginOut", "logout");
        map.put("/jsp/user.jsp", "authc,roles[user]");
        map.put("/jsp/admin.jsp", "authc,roles[admin]");
        map.put("/jsp/list.jsp", "roles[admin]");

        map.put("/**", "authc");

        return map;
    }

}
