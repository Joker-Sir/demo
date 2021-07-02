package com.joker.util.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class DemoReaderListener<T> extends AnalysisEventListener<T> {

    List<T> list = new ArrayList();

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        log.info("数据" + JSON.toJSONString(t));
        log.info("type" + t.getClass());
        list.add(t);
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("读取完毕。。。。");
        log.info(JSON.toJSONString(list));
    }



}
