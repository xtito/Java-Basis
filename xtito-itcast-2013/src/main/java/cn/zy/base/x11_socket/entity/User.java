package cn.zy.base.x11_socket.entity;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by [Zy]
 * 2016/11/24 19:49
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    private Map<String, Object> param = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Object> getParam() {
        return param == null ? param = new HashMap<String, Object>() : param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    public void put(String key, Object value) {
        this.param.put(key, value);
    }

}

