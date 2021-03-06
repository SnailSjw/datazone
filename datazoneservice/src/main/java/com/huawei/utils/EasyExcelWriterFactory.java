package com.huawei.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.handler.SheetWriteHandler;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

public class EasyExcelWriterFactory {
    private int sheetNo = 0;
    private ExcelWriter excelWriter = null;

    public EasyExcelWriterFactory(OutputStream outputStream) {
        excelWriter = EasyExcel.write(outputStream).build();
    }

    public EasyExcelWriterFactory(OutputStream outputStream, SheetWriteHandler writeHandler) {
        excelWriter = EasyExcel.write(outputStream).registerWriteHandler(writeHandler).build();
    }

    public EasyExcelWriterFactory(File file) {
        excelWriter = EasyExcel.write(file).build();
    }

    public EasyExcelWriterFactory(String filePath) {
        excelWriter = EasyExcel.write(filePath).build();
    }

    /**
     * 链式模板表头写入
     * @param headClazz 表头格式
     * @param data 数据 List-ExcelModel 或者List-List-Object
     * @param sheetName sheet名称
     * @param <T> 泛型
     * @return EasyExcelWriterFactory
     */
    public <T> EasyExcelWriterFactory writeModel(Class<T> headClazz, List<T> data, String sheetName){
        excelWriter.write(data, EasyExcel.writerSheet(this.sheetNo++, sheetName).head(headClazz).build());
        return this;
    }

    /**
     * 链式自定义表头写入
     * @param head 表头数据
     * @param data 数据 List-ExcelModel 或者List-List-Object
     * @param sheetName sheet名称
     * @param <T> 泛型
     * @return EasyExcelWriterFactory
     */
    public <T> EasyExcelWriterFactory write(List<List<String>> head, List<T> data, String sheetName){
        excelWriter.write(data, EasyExcel.writerSheet(this.sheetNo++, sheetName).head(head).build());
        return this;
    }

    public void finish() {
        excelWriter.finish();
    }
}
