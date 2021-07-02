package com.joker.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.joker.util.easyexcel.DemoData;
import com.joker.util.easyexcel.DemoDataListener;
import com.joker.util.easyexcel.DemoReaderListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* https://www.yuque.com/easyexcel/doc/easyexcel 官方文档
* */
public class ExcelUtils {


    /**
     * 写入数据
     * @param list 数据
     * @param sheetName 第一个sheet名(若不指定默认为第一个)
     * @param os 输出流
     * @param clz 数据模型
     * */
    public static void write(List<Object> list, String sheetName, OutputStream os, Class clz) throws IOException {
        ExcelWriter excelWriter = EasyExcelFactory.write(os, clz).build();
        WriteSheet sheet = new ExcelWriterSheetBuilder().sheetName(sheetName).sheetNo(0).build();
        excelWriter.write(list, sheet);
        excelWriter.finish();
        os.close();
    }

    /**
     * 写入数据
     * @param list 数据
     * @param sheetName 第一个sheet名(若不指定默认为第一个)
     * @param targetFile 目标文件
     * @param clz 数据模型
     * */
    public static void write(List<Object> list, String sheetName, File targetFile, Class clz) throws IOException {
        OutputStream os = new FileOutputStream(targetFile);
        write(list, sheetName, os, clz);
    }

    /**
     * 读取excel
     *
     * */
    public static void read(File source){
        EasyExcel.read(source, DemoData.class, new DemoReaderListener()).sheet().doRead();
    }

    public static void main(String[] args) {
        read(new File("d:\\demo.xlsx"));
    }



}
