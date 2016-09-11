package com.xtito.util.poi;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;

/**
 * Created by [Zy]
 * 2016/9/1 22:33
 */
public class WordUtil {

    public static void main(String[] args) {
        try {
            new WordUtil().htmlToWord2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void htmlToWord2() throws Exception {
        InputStream bodyIs = new FileInputStream("F:/LanEasy/POIzl/a.html");
        InputStream cssIs = new FileInputStream("F:/LanEasy/POIzl/a.css");
        String body = this.getContent(bodyIs);
        String css = this.getContent(cssIs);
        //拼一个标准的HTML格式文档
        String content = "<html><head><style>" + css + "</style></head><body>" + body + "</body></html>";
        InputStream is = new ByteArrayInputStream(body.getBytes("GBK"));
//        InputStream is = new ByteArrayInputStream(content.getBytes("GBK"));
        OutputStream os = new FileOutputStream("F:/LanEasy/POIzl/a.doc");
        this.inputStreamToWord(is, os);
    }

    /**
     * 把is写入到对应的word输出流os中
     * 不考虑异常的捕获，直接抛出
     * @throws IOException
     */
    private void inputStreamToWord(InputStream is, OutputStream os) throws IOException {
        POIFSFileSystem fs = new POIFSFileSystem();
        //对应于org.apache.poi.hdf.extractor.WordDocument
        fs.createDocument(is, "WordDocument");
        fs.writeFilesystem(os);
        os.close();
        is.close();
    }

    /**
     * 把输入流里面的内容以UTF-8编码当文本取出。
     * 不考虑异常，直接抛出
     * @throws IOException
     */
    private String getContent(InputStream... ises) throws IOException {
        if (ises != null) {
            StringBuilder result = new StringBuilder();
            BufferedReader br;
            String line;
            for (InputStream is : ises) {
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                while ((line=br.readLine()) != null) {
                    result.append(line);
                }
            }
            return result.toString();
        }
        return null;
    }
}
