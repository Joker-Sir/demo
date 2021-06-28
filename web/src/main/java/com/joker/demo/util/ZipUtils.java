package com.joker.demo.util;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * opt 路径处理待优化
 * */
public class ZipUtils {

    public static File packetZip(String targetFile, File file) throws IOException {
        File zipFile = new File(targetFile);
        packetZip(zipFile, file);
        return zipFile;
    }

    public static void packetZip(File targetFile, File file) throws IOException {
        ZipOutputStream zops = new ZipOutputStream(new FileOutputStream(targetFile));
        packetZip(zops, file, file.getPath().substring(0, file.getPath().lastIndexOf(File.separator) + 1));
        zops.close();
    }

    public static void packetZip(String targetFile, String file) throws IOException {
        File target = new File(targetFile);
        File source = new File(file);
        packetZip(target, source);
    }

    public static void packetZip(ZipOutputStream zops, File file, String relativePath) throws IOException {
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File item : files) {
                if (item.isFile()){
                    addZipEntry(zops, item, relativePath);
                }else {
                    packetZip(zops, item ,relativePath);
                }
            }
        }else {
            addZipEntry(zops, file, relativePath);
        }
    }

    public static void addZipEntry(ZipOutputStream zops, File node,String relativePath) throws IOException {
        ZipEntry zipEntry = new ZipEntry(node.getCanonicalPath().replace(relativePath, ""));
        zops.putNextEntry(zipEntry);
        byte[] bytes = fileToBytes(node);
        zops.write(bytes, 0, bytes.length);
    }


    public static byte[] fileToBytes(File file) {
        byte[] buffer = null;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int i ;
            while ((i = inputStream.read(bytes)) > -1){
                byteArray.write(bytes, 0, i);
            }
            buffer = byteArray.toByteArray();

            byteArray.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }



}
