package com.xtito.util.poi.replace;

import java.io.*;

import java.util.Map;


import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.model.DocumentProperties;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.DirectoryEntry;

import org.apache.poi.poifs.filesystem.DocumentEntry;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

public class HtmlToDoc {


       public static boolean html2Word(String filepath,String savePath) throws Exception {

              boolean flag = false;

              ByteArrayInputStream bais = null;
              FileOutputStream fos = null;
              POIFSFileSystem poifs =null;
              try {

                     if (!"".equals(filepath)) {

                            File fileDir = new File(filepath);

                            if (fileDir.exists()) {

                                   String content = readFile(filepath);

                                   byte b[] = content.getBytes("UTF-8");

                                   bais = new ByteArrayInputStream(b);
                                   poifs = new POIFSFileSystem();
                                   DocumentEntry wordDocument = poifs.createDocument(bais, "WordDocument");
//                                   DirectoryEntry directory = poifs.getRoot();
//                                   DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
                                   fos = new FileOutputStream(savePath);
                                   poifs.writeFilesystem(fos);

                            }
                     }
              } catch (IOException e) {
                     e.printStackTrace();
              } finally {
                     if(poifs!=null) poifs.close();
                     if(fos != null) fos.close();
                     if(bais != null) bais.close();
              }
              return flag;

       }


       public static boolean html2Word(String filepath) throws Exception {

              boolean flag = false;

              ByteArrayInputStream bais = null;

              FileOutputStream fos = null;

              try {

                     if (!"".equals(filepath)) {

                            File fileDir = new File(filepath);

                            if (fileDir.exists()) {

                                   String content = readFile(filepath);
                                   System.out.println(content);

                                   byte b[] = content.getBytes("UTF-8");

                                   bais = new ByteArrayInputStream(b);

                                   POIFSFileSystem poifs = new POIFSFileSystem();

                                   DirectoryEntry directory = poifs.getRoot();

                                   DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);

                                   fos = new FileOutputStream(filepath + ".doc");

                                   poifs.writeFilesystem(fos);

                                   bais.close();

                                   fos.close();

                            }

                     }

 

              } catch (IOException e) {

                     e.printStackTrace();

              } finally {

                     if(fos != null) fos.close();

                     if(bais != null) bais.close();

              }

              return flag;

       }


       public static void tjdaHtml2Doc(String stuID) throws Exception {
              String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
              path=path.substring(1,path.indexOf("WEB-INF"));
              String templatePath=path+"/tijiandangan/"+stuID+"_word.html";
              String fileName=path+"/tijiandangan/"+stuID+".doc";
              html2Word(templatePath, fileName);
              new File(templatePath).delete(); //删除html模版
       }


       public static void djdHtml2Doc(String stuID) throws Exception {
              String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
              path=path.substring(1,path.indexOf("WEB-INF"));
              String templatePath=path+"/StudentPic/"+stuID+"_word.html";
              String fileName=path+"/StudentPic/"+stuID+".doc";
              html2Word(templatePath, fileName);
              new File(templatePath).delete(); //删除html模版
       }
 

       /**

        * 读取html文件到字符串

        * @param filename

        * @return

        * @throws Exception

        */

       public static String readFile(String filename) throws Exception {

              FileInputStream fileInputStream = null;

              StringBuffer buffer = new StringBuffer("");

              BufferedReader br = null;
              InputStreamReader inputStreamReader =null;
              try {
                     fileInputStream = new FileInputStream(filename);
                     inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                     br = new BufferedReader(inputStreamReader);

                     buffer = new StringBuffer();

                     while (br.ready())

                            buffer.append((char) br.read());

              } catch (Exception e) {

                     e.printStackTrace();

              } finally {
                     if(br!=null) br.close();
                     if(fileInputStream!=null)fileInputStream.close();
                     if(inputStreamReader!=null)inputStreamReader.close();
              }

              return buffer.toString();

       }

      

       public static void main(String[] args) throws Exception {

              HtmlToDoc.html2Word("d:/1111111111111111111.html");

       }

}
