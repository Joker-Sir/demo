package com.joker.demo.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PdfUtils {

    public static void fillField(String template, String target, Map<String,String> value) throws IOException, DocumentException {
        FileInputStream inputStream = new FileInputStream(new File(template));
        PdfReader reader = new PdfReader(inputStream);
        PdfStamper pdfStamper = new PdfStamper(reader, new FileOutputStream(target));
        AcroFields acroFields = pdfStamper.getAcroFields();
        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
        Font font = new Font(baseFont);
        font.setSize(14);

        Map<String, AcroFields.Item> map = acroFields.getFields();
        //第三种方式Map.Entry<String, String>的加强for循环遍历输出键key和值value
        for(Map.Entry<String, AcroFields.Item> entry : map.entrySet()){
            String key = entry.getKey();
            if ("detail".equals(key)){
                continue;
            }
            // 通过域名获取所在页和坐标，左下角为起点
            int pageNo = acroFields.getFieldPositions(key).get(0).page;
            // 获取操作的页面
            PdfContentByte under = pdfStamper.getOverContent(pageNo);
            ColumnText columnText = new ColumnText(under);
            // llx 和 urx  最小的值决定离左边的距离. lly 和 ury 最大的值决定离下边的距离
            Rectangle signRect = acroFields.getFieldPositions(key).get(0).position;
            columnText.setSimpleColumn(signRect.getLeft(), signRect.getBottom(), signRect.getRight(), signRect.getTop() - signRect.getHeight());
            String text = "测试文本";
            if (null != value.get(key)){
                text = value.get(key);
            }
            Paragraph elements = new Paragraph(0, new Chunk(text));
            // 设置字体，如果不设置添加的中文将无法显示
            elements.setFont(font);
            columnText.addElement(elements);
            columnText.go();
        }

        List<AcroFields.FieldPosition> detail = acroFields.getFieldPositions("detail");
        AcroFields.FieldPosition fieldPosition = detail.get(0);
        int pageNo = fieldPosition.page;
        // 获取操作的页面
        PdfContentByte under = pdfStamper.getOverContent(pageNo);
        String text = value.get("detail");

        ColumnText columnText = new ColumnText(under);
        // llx 和 urx  最小的值决定离左边的距离. lly 和 ury 最大的值决定离下边的距离
        Rectangle signRect = fieldPosition.position;
        columnText.setAlignment(Element.ALIGN_CENTER);

        // 设置字体，如果不设置添加的中文将无法显示
        // 与前一种方式区别在于 创建chunk时是否有字体 居中无效不显示
        Paragraph elements = new Paragraph(text, font);
        columnText.setText(elements);
        columnText.setSimpleColumn(signRect);
        columnText.go();

        pdfStamper.close();
        reader.close();
    }

    public static void main(String[] args) throws IOException, DocumentException {
        Map<String, String> map = new HashMap<>();
        map.put("title","标题");
        map.put("summary","摘要");
        map.put("content","内容");
        map.put("detail","详尽内容");
        fillField("D:\\github\\demo\\src\\main\\resources\\file\\testPdf.pdf","D:\\liuchaoxiong\\桌面\\testPdf1.pdf",map);
    }


}
