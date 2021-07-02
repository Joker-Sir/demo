package com.joker.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.joker.util.easyexcel.DemoData;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
* https://www.yuque.com/easyexcel/doc/easyexcel 官方文档
* */
public class ExcelUtils {


    /**
     * 写入数据 默认写入第一个sheet
     * @param list 数据
     * @param sheetName 第一个sheet名
     * @param os 输出流
     * */
    public static void write(List<Object> list,String sheetName ,OutputStream os) throws IOException {
        ExcelWriter excelWriter = EasyExcelFactory.write(os, DemoData.class).build();
        WriteSheet sheet = new ExcelWriterSheetBuilder().sheetName(sheetName).build();
        excelWriter.write(list, sheet);
        excelWriter.finish();
        os.close();
    }

    /**
     * 测试数据
     * */
    private static List exampleData(){
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData demoData = new DemoData();
            demoData.setDate(new Date());
            demoData.setDoubleData(23.32 + i);
            demoData.setString("number" + i);
            list.add(demoData);
        }
        return list;
    }



}
