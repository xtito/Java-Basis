package cn.zy.base.x12_regex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by [Zy]
 * 2016/3/8 12:52
 */
public class Test {

    public static void main(String[] args) {

        // 定义1991/03/13匹配正则
        /*String id = "513723199103135853";
        if (id.length() > 14) {
            id = id.substring(6, 14);
        }

        String reg = "\\d{4}(/\\d{1,2}){2}";
        System.out.println(id);*/

        // 定义1991-03-13匹配正则

        /*String a =  "(((\\d+-\\d+)|\\d+),?)+";
        a =  "^((([0-9]+-[0-9]+)|[0-9]+),?)+$";
        a = "[0-9]+-[0-9]+";
        a = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$";
        String str = "1,2,3,4-6,9,20,15-30,355,340-500,6,7-9,";
        str = "1,2,3,9,20,355,6";
        str = "2016-02-3";
        System.out.println(str.matches(a));*/


        /*List<Object[]> lists = new ArrayList<Object[]>();
        Object[] obj = {1,5};
        Object[] obj1 = {20,50};
        Object[] obj2 = {44,500};
        lists.add(obj);
        lists.add(obj1);
        lists.add(obj2);

        for (int i=0; i<lists.size(); i++) {
            System.out.println(lists.get(i)[0]);
        }*/

//        System.out.println(isNull(" ","1","  ", "aa"));


        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "1");
//        System.out.println(map.size());

        /*try {
            Date start = new SimpleDateFormat("yyyy-MM-dd").parse("2015-03-14");
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse("2015-04-14");

            System.out.println("start小于end： " + end.before(start));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

    }

    public static boolean isNull(String... str) {

        boolean isNull = false;

        for (String s: str) {
            if (s==null || "".equals(s.trim())) {
                isNull = true;
                break;
            }
        }
        return isNull;
    }


    public static int add(Integer num) {
        return (num = (num + 1));
    }

    public static double avg(int a, int b) {
        return (a + b) / 2;
    }

}
