package com.core.util;

import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * IO工具类
 * Created by [ZY]
 * 2016/9/29 10:52
 */
public class IOUtils {


    /**
     * 将流另存文件
     * @param is 读取文件的字节输入流
     * @param outFile 输出文件
     */
    public static void streamSaveAsFile(InputStream is, File outFile) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(is);// 输入缓冲流对象
            bos = new BufferedOutputStream(new FileOutputStream(outFile));// 输出缓冲流对象

            byte[] buf = new byte[1024];
            int len = 0;

            // 缓冲区的read方法从缓冲区中读取 1024 个字节
            while((len = bis.read(buf)) != -1) {
                // 将读取到的字节数组写入到缓冲区
                bos.write(buf, 0, len);
                // 刷新缓冲区，将数据刷到目的地
                bos.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将文件字节数组转存为图片
     * @param b 文件字节数组
     * @param path 转存文件路径
     * @param fileName 转存文件名
     */
    public static void byteSaveAsFile(byte[] b, String path, String fileName) {

        File dir = new File(path);

        if (!dir.exists()) {
            boolean createOk = dir.mkdirs();
        }

        // 如果文件存在，并且是文件夹
        if (dir.exists() && dir.isDirectory()) {
            File outFile = new File(path, fileName);
            InputStream is = byte2InputStream(b);
            streamSaveAsFile(is, outFile);
        }
    }


    /**
     * 将字节输入流转为字节数组
     * @param is 字节输入流
     * @return 字节数组
     */
    public static byte[] inputStream2Byte(InputStream is) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = null;

        try {
            byte[] buf = new byte[1024];
            int len = 0;

            while((len = is.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }

            bytes = baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bytes;
    }

    /**
     * 将字节输入流转为字节数组，文件如果过大可能会内存溢出
     * @param is 要转换的 InputStream 流
     * @return 转换后的字节数组
     */
    public static byte[] stream2Byte(InputStream is) {
        byte[] buf = null;
        try {
            int count = 0;
            while (count == 0) {
                count = is.available();
            }

            buf = new byte[count];
            int len = is.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buf;
    }

    /**
     * 将指定文件转为字节数组
     * @param filePath 文件路径
     * @return 文件转换后的字节数组
     */
    public static byte[] file2Bytes(String filePath) {

        byte[] bytes = null;

        try {
            if (filePath != null) {
                File file = new File(filePath);

                // 如果文件存在，并且不是文件夹
                if (file.exists() && !file.isDirectory()) {
                    if (file.exists()) {
                        InputStream is = new FileInputStream(file);
                        bytes = inputStream2Byte(is);
                    } else {
                        throw new RuntimeException("该路径文件不存在");
                    }
                } else {
                    throw new RuntimeException("要转换为字节数组的对象不能是文件夹");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return bytes;
    }


    /**
     * 将字节数组转为 InputStream 流
     * @param b 要转换的字节数组
     * @return 转换后的 InputStream 流
     */
    public static InputStream byte2InputStream(byte[] b) {
        return new ByteArrayInputStream(b);
    }


    /**
     * 根据图片路径，获取图片的BASE64编码
     * @param imgPath 要转换的图片地址
     * @return BASE64图片编码
     */
    public static String getImgBase64Encoder(String imgPath) {
        byte[] data = IOUtils.file2Bytes(imgPath);
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }


    /**
     * 删除指定文件，或删除指定目录及其目录下所有文件和文件夹
     * @param file 要删除的文件或文件目录
     * @return 删除成功 true  删除失败 false
     */
    public static boolean deleteFileAndDir(File file) {

        boolean isOk = true;

        // 判断目录是否存在
        if (file.exists()) {

            // 如果是文件夹
            if (file.isDirectory()) {
                // 列出当前目录下的文件以及文件夹File[]
                File[] files = file.listFiles();

                // 如果该目录是系统级文件夹，java没有访问权限，会返回null数组
                if (files != null) {
                    // 如果该目录下有文件或文件夹，则循环
                    if (files.length > 0) {
                        for (File innerFile : files) {
                            // 对遍历到的File对象判断是否是目录
                            if (innerFile.isDirectory()) {
                                // 如果是文件夹则递归
                                deleteFileAndDir(innerFile);
                            } else {
                                isOk = innerFile.delete();
                            }
                        }
                    }

                    // 如果当前目录下没有文件或文件夹，或已删除文件夹下文件，则直接删除该目录
                    isOk = file.delete();
                }
            } else {
                // 如果是文件直接删除
                isOk = file.delete();
            }
        }

        return isOk;
    }

}
