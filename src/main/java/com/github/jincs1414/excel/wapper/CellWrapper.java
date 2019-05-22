package com.github.jincs1414.excel.wapper;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 单元格的包装
 */
public class CellWrapper {

    private final static short FontHeightInPoints = 12;
    /**
     * 码值
     */
    private String code;
    /**
     * 描述
     */
    private String desc;
    /**
     * 是否必填
     */
    private boolean require;
    /**
     * 是否下拉
     */
    private boolean selectInput;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isRequire() {
        return require;
    }

    public boolean isSelectInput() {
        return selectInput;
    }

    public void wapperHeader(Cell cell){
        Workbook workbook = cell.getSheet().getWorkbook();
        CellStyle style = workbook.createCellStyle();
        style.setLocked(true); //设置保护，不让第一行改动
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        //字体样式
        Font fontStyle = workbook.createFont();
        fontStyle.setFontName("微软雅黑");
        fontStyle.setFontHeightInPoints(FontHeightInPoints);
        fontStyle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style.setFont(fontStyle);
        if (require){
            fontStyle.setColor(HSSFColor.RED.index); //必填字段标红
        }
        cell.setCellStyle(style); //加样式
        cell.setCellValue(this.getDesc()); //往单元格里写数据
    }

    public void wapper(Cell cell){
        cell.setCellValue(this.getDesc()); //往单元格里写数据
    }

    public CellWrapper(Builder builder) {
        //这里可以进行检查
        this.code = builder.code;
        this.desc = builder.desc;
        this.require = builder.require;
        this.selectInput = builder.selectInput;
    }

    public static class Builder {
       /**
        * 码值
        */
       private String code;
       /**
        * 描述
        */
       private String desc;
        /**
         * 是否必填
         */
        private boolean require;
        /**
         * 是否下拉
         */
        private boolean selectInput;

       public Builder setCode(String code) {
           this.code = code;
           return this;
       }

       public Builder setDesc(String desc) {
           this.desc = desc;
           return this;
       }

        public Builder setSelectInput(boolean selectInput) {
            this.selectInput = selectInput;
            return this;
        }

        public Builder setRequire(boolean require) {
            this.require = require;
            return this;
        }

        public CellWrapper build(){
           return new CellWrapper(this);
       }
   }
}
