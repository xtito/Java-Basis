package com.xtito.util.poi.replace;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 *
 * Created by root on 2016/4/7.
 */
public class FileUtil {
    public static boolean fileExists(String path){
        return new File(path).exists();
    }

    public static boolean fileExists(File file){
        return file.exists();
    }


    /**
     * 复制文件
     * @param srcFile
     * @param destFile
     * @param newFileName
     */
    public static void copyFile(File srcFile,File destFile,String newFileName){
        long copySize=0;
        if(!srcFile.exists()){
            System.out.println("源文件不存在");
            copySize=-1;
        }else if(!destFile.exists()){
            System.out.println("目标文件夹不存在");
            copySize=-1;
        }else if(newFileName==null){
            System.out.println("文件名不能为null");
            copySize=-1;
        }else{
            BufferedInputStream bin=null;
            BufferedOutputStream bout=null;
            try{
                bin=new BufferedInputStream(new FileInputStream(srcFile));
                bout=new BufferedOutputStream(new FileOutputStream(new File(destFile,newFileName)));
                int b=0,i=0;
                while ((b=bin.read())!=-1){
                    bout.write(b);
                    i++;
                }
                bout.flush();
                copySize=i;
            }catch (Exception e){
                e.printStackTrace();
                copySize=-1;
            }finally {
                if(bin!=null){
                    try {
                        bin.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(bout!=null){
                    try {
                        bout.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    /**
     * 快速复制文件
     * @param srcFile
     * @param destFile
     * @param newFileName
     */
    public static void copyFileFast(File srcFile,File destFile,String newFileName){
        long copySize=0;
        if(!srcFile.exists()){
            System.out.println("源文件不存在");
            copySize=-1;
        }else if(!destFile.exists()){
            System.out.println("目标文件夹不存在");
            copySize=-1;
        }else if(newFileName==null){
            System.out.println("文件名不能为null");
            copySize=-1;
        }else{
            FileChannel fcin=null;
            FileChannel fcout=null;
            try{
                fcin=new FileInputStream(srcFile).getChannel();
                fcout=new FileOutputStream(new File(destFile,newFileName)).getChannel();
                long size=fcin.size();
                fcin.transferTo(0,fcin.size(),fcout);
                copySize=size;
            }catch (Exception e){
                e.printStackTrace();
                copySize=-1;
            }finally {
                if(fcin!=null){
                    try {
                        fcin.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(fcout!=null){
                    try {
                        fcout.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
