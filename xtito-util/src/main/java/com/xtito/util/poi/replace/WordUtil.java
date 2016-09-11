package com.xtito.util.poi.replace;

import com.xtito.util.beans.CustomXWPFDocument;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Created by root on 2016/4/6.
 */
public class WordUtil {


    /**
     * 替换word文档中的变量
     * @param templatePath Word文档模板路径
     * @param savePath Word文档数据替换后保存路径
     * @param paraParam 段落中的变量所需参数
     * @param tableParam 表格中的变量所需参数
     */
    public static void replaceInDoc(String templatePath, String savePath,
                                    Map<String, Object> paraParam, Map<String, Object> tableParam) {

        InputStream is = null;
        OutputStream os = null;

        try {

            is = new FileInputStream(templatePath);
            os = new FileOutputStream(savePath);

            XWPFDocument doc = new XWPFDocument(is);

            //替换段落里面的变量
            replaceInPara(doc, paraParam);

            //替换表格里面的变量
            replaceInTable(doc, tableParam);

            doc.write(os);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // 关闭输出流
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 替换段落里面的变量
     * @param doc 要替换的文档
     * @param params 参数
     */
    public static void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
        if (params != null && params.size() > 0) {
            Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
            while (iterator.hasNext()) {
                XWPFParagraph para = iterator.next();
                replaceInPara(para, params);
            }
        }
    }

    /**
     * 替换段落里面的变量
     * @param para 要替换的段落
     * @param params 参数
     */
    public static void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
        if (params != null && params.size() > 0) {
            if (matcher(para.getParagraphText()).find()) {
                List<XWPFRun> runs = para.getRuns();
                for (int i=0; i<runs.size(); i++) {
                    XWPFRun run = runs.get(i);
                    String runText = run.toString();
                    Matcher matcher = matcher(runText);
                    if (matcher.find()) {
                        while ((matcher = matcher(runText)).find()) {
                            runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
                        }
                        //直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
                        //所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
                        para.removeRun(i);
                        para.insertNewRun(i).setText(runText);
                    }
                }
            }
        }
    }

    /**
     * 替换表格里面的变量
     * @param doc 要替换的文档
     * @param params 参数
     */
    public static void replaceInTable(XWPFDocument doc, Map<String, Object> params) {

        if (params != null && params.size() > 0) {
            Iterator<XWPFTable> iterator = doc.getTablesIterator();

            while (iterator.hasNext()) {

                XWPFTable table = iterator.next();
                List<XWPFTableRow> rows = table.getRows();

                for (XWPFTableRow row : rows) {

                    List<XWPFTableCell> cells = row.getTableCells();

                    for (XWPFTableCell cell : cells) {

                        List<XWPFParagraph> paras = cell.getParagraphs();

                        for (XWPFParagraph para : paras) {
                            replaceInPara(para, params);
                        }
                    }
                }
            }
        }
    }

    /**
     * 正则匹配字符串
     * @param str 匹配的字符串
     * @return 匹配结果
     */
    private static Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        return pattern.matcher(str);
    }



    /**
     * 根据指定的参数值、模板，生成 word 文档
     * @param param 需要替换的变量
     * @param template 模板
     */
    public static CustomXWPFDocument generateWord(Map<String, Object> param, String template) {
        CustomXWPFDocument doc = null;
        try {
            OPCPackage pack = POIXMLDocument.openPackage(template);
            doc = new CustomXWPFDocument(pack);
            if (param != null && param.size() > 0) {

                //处理段落
                List<XWPFParagraph> paragraphList = doc.getParagraphs();
                processParagraphs(paragraphList, param, doc);

                //处理表格
                Iterator<XWPFTable> it = doc.getTablesIterator();
                while (it.hasNext()) {
                    XWPFTable table = it.next();
                    List<XWPFTableRow> rows = table.getRows();

                    for (XWPFTableRow row : rows) {
                        List<XWPFTableCell> cells = row.getTableCells();

                        for (XWPFTableCell cell : cells) {
                            List<XWPFParagraph> paragraphListTable =  cell.getParagraphs();
                            processParagraphs(paragraphListTable, param, doc);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }
    /**
     * 处理段落
     * @param paragraphList 要替换的集合
     */
    public static void processParagraphs(List<XWPFParagraph> paragraphList, Map<String, Object> param, CustomXWPFDocument doc) {

        if(paragraphList != null && paragraphList.size() > 0){

            for(XWPFParagraph paragraph:paragraphList){

                List<XWPFRun> runs = paragraph.getRuns();

                if (runs != null && runs.size() > 0) {
                    for (int i=0; i<runs.size(); i++) {

                        XWPFRun run = runs.get(i);
                        String text = run != null ? run.toString() : "";
                        text = text != null ? text.trim() : "";
                        Object value = param.get(text);

                        if (!"".equals(text) && value != null) {

                            if (value instanceof String) {
                                // 文本替换
                                text = text.replace(text, value.toString());
                            } else if (value instanceof Map) {
                                // 图片替换
                                text = text.replace(text, "");
                                Map pic = (Map) value;
                                int width = Integer.parseInt(pic.get("width").toString());
                                int height = Integer.parseInt(pic.get("height").toString());
                                int picType = getPictureType(pic.get("type").toString());
                                byte[] byteArray = (byte[]) pic.get("content");
                                ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteArray);
                                try {
                                    String blipId = doc.addPictureData(byteInputStream, picType);
                                    int id = doc.getNextPicNameNumber(picType);
                                    doc.createPicture(blipId, id, width, height, paragraph);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            paragraph.removeRun(i);
                            paragraph.insertNewRun(i).setText(text);
                        }
                    }
                }
            }
        }
    }
    /**
     * 根据图片类型，取得对应的图片类型代码
     * @param picType 图片类型
     * @return int
     */
    private static int getPictureType(String picType){
        int res = CustomXWPFDocument.PICTURE_TYPE_PICT;
        if (picType != null) {
            if (picType.equalsIgnoreCase("png")) {

                res = CustomXWPFDocument.PICTURE_TYPE_PNG;

            } else if (picType.equalsIgnoreCase("dib")) {

                res = CustomXWPFDocument.PICTURE_TYPE_DIB;

            } else if (picType.equalsIgnoreCase("emf")) {

                res = CustomXWPFDocument.PICTURE_TYPE_EMF;

            } else if (picType.equalsIgnoreCase("jpg") || picType.equalsIgnoreCase("jpeg")) {

                res = CustomXWPFDocument.PICTURE_TYPE_JPEG;

            } else if (picType.equalsIgnoreCase("wmf")) {

                res = CustomXWPFDocument.PICTURE_TYPE_WMF;
            }
        }
        return res;
    }
    /**
     * 将输入流中的数据写入字节数组
     * @param path 图片路径地址
     * @return 字节数据
     */
    public static byte[] img2ByteArray(String path){

        FileInputStream fis = null;
        byte[] bytes = null;

        if (path != null && !"".equals(path)) {
            try {

                fis = new FileInputStream(path);

                bytes = FileCopyUtils.copyToByteArray(fis);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return bytes;

    }

}
