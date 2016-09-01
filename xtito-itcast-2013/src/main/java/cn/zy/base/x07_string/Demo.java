package cn.zy.base.x07_string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by [Zy]
 * 2016/7/28 14:52
 */
public class Demo {

    private static Map<String, Object> map;

    public static void main(String[] args) {
        if (map == null || map.size() == 0) {
            map = getMap();
        }

        map.put("1a", 123);
        map.put("8a", "abc");
        System.out.println(1);
    }

    public static Map<String, Object> getMap() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("1a", 1);
        map.put("2a", 2);
        map.put("3a", 3);
        map.put("4a", 4);
        map.put("5a", 5);
        map.put("6a", 6);
        map.put("7a", 7);
        map.put("8a", 8);
        map.put("9a", 9);
        map.put("10a", 10);
        return map;
    }

}
