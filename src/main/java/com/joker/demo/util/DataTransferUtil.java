package com.joker.demo.util;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;

public class DataTransferUtil {

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

    public static InputStream bytesToInputStream(byte[] bytes){
        InputStream is = new ByteArrayInputStream(bytes);
        return is;
    }

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



}
