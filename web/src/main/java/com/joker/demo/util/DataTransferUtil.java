package com.joker.demo.util;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;
import java.nio.channels.FileChannel;

public class DataTransferUtil {


    /**
     * 将输入流转为二进制数组
     * @param is 输入流
     * @return byte[] 数组
     * */
    public static byte[] inputStreamToByte(InputStream is){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[0];
        try {
            byte[] buffer = new byte[1024*1024];
            int n = 0;
            while (-1 != (n = is.read(buffer))) {
                baos.write(buffer, 0, n);
            }
            bytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(baos);
        }
        return bytes;
    }

    /**
     * 数组转为输入流
     * @param bytes byte数组
     * @return inpustream 输入流
     * */
    public static InputStream bytesToInputStream(byte[] bytes){
        InputStream is = new ByteArrayInputStream(bytes);
        return is;
    }

    /**
     * 将输入流写入到目标文件
     * @param destPath 目标文件路劲
     * @param is 数据流
     * @return file 目标文件
     * */
    public static File inputStreamToFile(String destPath, InputStream is) {
        File file = new File(destPath);
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int n;
            byte[] buffer = new byte[8192];
            while ((n = is.read(buffer)) != -1) {
                os.write(buffer, 0, n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(os);
            IOUtils.closeQuietly(is);
        }
        return file;
    }

    /**
     * in a way that can be optimized by many operating systems
     * into a very fast transfer directly to or from the filesystem cache.
     * 节选自FileChannel描述
     * @param from 源文件路径
     * @param to 目标文件路径
     * */
    public static void copyFile(String from, String to) throws Exception{
        File fromFile = new File(from);
        File toFile = new File(to);
        copyFile(fromFile, toFile);
    }

    /**
     * copy File from [from] to [to]
     * @param from 源文件
     * @param to 目标文件
     * */
    public static void copyFile(File from, File to) throws Exception{
        FileChannel fromChannel = new FileInputStream(from).getChannel();
        FileChannel toChannel = new FileOutputStream(to).getChannel();
        fromChannel.transferTo(0,fromChannel.size(),toChannel);
        fromChannel.close();
        toChannel.close();
    }


}
