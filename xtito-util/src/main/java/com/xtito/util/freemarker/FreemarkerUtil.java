package com.xtito.util.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Freemarker 静态模板工具类
 *
 * Created by [Zy]
 * 2016/9/11 13:58
 */
public class FreemarkerUtil {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("serialId", "0001");
        map.put("tid", "T0001");
        map.put("studentId", "2016720001");
        map.put("studentImg", "图片");
        map.put("studentName", "张三");
        map.put("birthday", "1991-04-01");
        map.put("scoolName", "北京清华附中一中");
        map.put("province", "北京");
        map.put("height", "175");
        map.put("tiZhong", "60");
        map.put("zuoGao", "90");
        map.put("xiongWei", "90");
        map.put("xiaZhiChang", "80");
        map.put("shangZhiChangZuo", "75");
        map.put("shangZhiChangYou", "75");
        map.put("woLiZuo", "40");
        map.put("woLiYou", "40");
        map.put("ceLiangBeiZhu", "无");
        map.put("ceLiangJieLun", "合格");
        map.put("clYiShi1", "李四");
        map.put("clYiShi2", "王五");

        map.put("zhuSuBingShi", "无");
        map.put("yiBanFaYu", "正常");
        map.put("tiZhi", "正常");
        map.put("piFu", "正常");
        map.put("linBaJie", "正常");
        map.put("touJingBu", "正常");
        map.put("xiongFuBu", "正常");
        map.put("jiZhu", "正常");
        map.put("siZhiGuanJie", "正常");
        map.put("miNiaoShengZhiQi", "正常");
        map.put("gangMen", "正常");
        map.put("liLang", "正常");
        map.put("zdBeiZhu", "无");
        map.put("zdJieLun", "合格");
        map.put("zdYiShi1", "孙三");
        map.put("zdYiShi2", "赵六");

        map.put("zhenDuan", "合格");
        map.put("ksJieLun", "合格");
        map.put("zhuRen", "朱科顺");
        map.put("ksXiaJieRiQi", "2016-9-11");

        try {
            FreemarkerUtil freemarkerUtil = new FreemarkerUtil();
            freemarkerUtil.createDocx("", map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建word2007格式的word文件
     * @param templatePath 指定模板路径
     * @param data 设置模板数据源数据
     */
    public void createDocx(String templatePath, Map<String, Object> data) throws IOException {

        Version version = new Version("2.3.25-incubating");
        Configuration config = new Configuration(version);
        config.setDefaultEncoding("UTF-8");
        // 这里是指放在classes下
//        config.setClassForTemplateLoading(this.getClass(), "/template");
        config.setDirectoryForTemplateLoading(new File("F:\\test"));

        // 获取模板
        Template template = config.getTemplate("template.ftl");

        // Word输出路径
        File outFile = new File("F:/test/模板.doc");
        Writer out = null;

        try {

            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

            template.process(data, out);
            // 关闭流
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
