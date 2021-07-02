package com.joker.util;

import com.joker.util.easyexcel.DemoData;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExcelUtilsTest {

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

    @Test
    void write() {
        try {
            ExcelUtils.write(exampleData(),
                    "demo", new File("d:\\demo.xlsx"), DemoData.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }







}