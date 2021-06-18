package com.joker.demo.util;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

    public static File packetZip(String targetFile, File file) throws IOException {
        File zipFile = new File(targetFile);
        packetZip(zipFile, file);
        return zipFile;
    }

    private static void packetZip(File targetFile, File file) throws IOException {
        ZipOutputStream zops = new ZipOutputStream(new FileOutputStream(targetFile));
        ZipEntry zipEntry = new ZipEntry(file.getName());
        zops.putNextEntry(zipEntry);
        byte[] bytes = fileToBytes(file);
        zops.write(bytes, 0, bytes.length);
        zops.close();
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
