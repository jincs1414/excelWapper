package com.github.jincs1414.excel.wapper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * sheet的包装类
 */
public class SheetWrapper {
    /**
     * 原始的sheet
     */
    private Sheet sheet;
    /**
     * 包装的表头
     */
    private RowWrapper header;
    /**
     * 包装的行数据
     */
    private RowsWapper contents;
    /**
     * 输出的流
     */
    private OutputStream stream;

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public RowWrapper getHeader() {
        return header;
    }

    public void setHeader(RowWrapper header) {
        this.header = header;
    }

    public RowsWapper getContents() {
        return contents;
    }

    public void setContents(RowsWapper contents) {
        this.contents = contents;
    }

    public SheetWrapper(Builder builder) {
        if(builder == null || builder.sheet == null){
            throw new IllegalArgumentException("未设置相应的对象");
        }
        this.sheet = builder.sheet;
        //执行表格创建
        if(builder.header != null){
            this.header = builder.header;
            buildHeader();
        }
        if (builder.contents != null) {
            this.contents = builder.contents;
            this.contents.apply(this.header);
            buildContents();
        }
    }

    /**
     * 创建表头
     */
    private void buildHeader(){
        Row row = sheet.createRow(0);//第一个sheet的第一行为标题
        List<CellWrapper> cellWrappers = this.header.getCells();
        for (int i = 0; i < cellWrappers.size(); i++) {
            cellWrappers.get(i).wapperHeader(row.createCell(i));
        }
    }

    /**
     * 创建内容
     */
    private void buildContents(){
        List<RowWrapper>  rowWrappers = this.contents.getRowWrappers();
        List<CellWrapper> cellWrappers;
        Row row;
        for (RowWrapper rowWrapper : rowWrappers) {
            cellWrappers = rowWrapper.getCells();
            row = sheet.createRow(sheet.getLastRowNum()+1);//第一个sheet的第一行为标题
            for (int i = 0; i < cellWrappers.size(); i++) {
                cellWrappers.get(i).wapper(row.createCell(i));
            }
        }
    }

    public Sheet get() {
        return this.sheet;
    }

    public static class Builder{
        private RowWrapper header;
        private RowsWapper contents;
        private Sheet sheet;

        public Builder createSheet(Class<? extends Workbook> workbookClass){
            try {
                this.sheet = workbookClass.newInstance().createSheet();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return this;
        }
        public Builder setHeader(RowWrapper header) {
            this.header = header;
            return this;
        }

        public Builder setContents(RowsWapper contents) {
            this.contents = contents;
            return this;
        }

        public Builder setSheet(Sheet sheet) {
            this.sheet = sheet;
            return this;
        }

        public SheetWrapper build(){
            return new SheetWrapper(this);
        }

    }


    public SheetWrapper writeTo(OutputStream stream){
        try {
            this.stream = stream;
            sheet.getWorkbook().write(stream);
        }catch (Exception e){
            e.printStackTrace();
            throw new IllegalStateException("写入失败");
        }
        return this;
    }

    public void closeStream(){
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
