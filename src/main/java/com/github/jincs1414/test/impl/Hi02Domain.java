package com.github.jincs1414.test.impl;

import java.math.BigDecimal;

public class Hi02Domain {

    /**
     * 数据指标id
     */
    private BigDecimal chi020;

    /**
     * 服务事项编码
     */
    private String chi031;

    /**
     * 服务事项名称
     */
    private String chi021;

    /**
     * 数据指标名
     */
    private String chi022;

    /**
     * 数据指标注释
     */
    private String chi023;

    /**
     * 数据指标类型(number、char、date)
     */
    private String chi024;

    /**
     * 列表展示长度
     */
    private String chi025;

    /**
     * 是否必填项
     */
    private String chi026;

    /**
     * 显示顺序
     */
    private Long chi027;

    /**
     * 填写规范
     */
    private String chi028;

    /**
     * 是否下拉选
     */
    private String chi029;

    private String yab003;


    public Hi02Domain() {
    }

    public Hi02Domain(BigDecimal chi020) {
        this.chi020 = chi020;
    }


    public String getYab003() {
        return this.yab003;
    }

    public void setYab003(String yab003) {
        this.yab003 = yab003;
    }

    /**
     * 设置 chi020 数据指标id
     *
     * @param chi020 数据指标id
     */
    public void setChi020(BigDecimal chi020) {
        this.chi020 = chi020;
    }

    /**
     * 获取 chi020 数据指标id
     *
     * @return 数据指标id
     */
    public BigDecimal getChi020() {
        return this.chi020;
    }

    /**
     * 设置 chi031 服务事项编码
     *
     * @param chi031 服务事项编码
     */
    public void setChi031(String chi031) {
        this.chi031 = chi031;
    }

    /**
     * 获取 chi031 服务事项编码
     *
     * @return 服务事项编码
     */
    public String getChi031() {
        return this.chi031;
    }

    /**
     * 设置 chi021 服务事项名称
     *
     * @param chi021 服务事项名称
     */
    public void setChi021(String chi021) {
        this.chi021 = chi021;
    }

    /**
     * 获取 chi021 服务事项名称
     *
     * @return 服务事项名称
     */
    public String getChi021() {
        return this.chi021;
    }

    /**
     * 设置 chi022 数据指标名
     *
     * @param chi022 数据指标名
     */
    public void setChi022(String chi022) {
        this.chi022 = chi022;
    }

    /**
     * 获取 chi022 数据指标名
     *
     * @return 数据指标名
     */
    public String getChi022() {
        return this.chi022;
    }

    /**
     * 设置 chi023 数据指标注释
     *
     * @param chi023 数据指标注释
     */
    public void setChi023(String chi023) {
        this.chi023 = chi023;
    }

    /**
     * 获取 chi023 数据指标注释
     *
     * @return 数据指标注释
     */
    public String getChi023() {
        return this.chi023;
    }

    /**
     * 设置 chi024 数据指标类型(number、char、date)
     *
     * @param chi024 数据指标类型(number、char、date)
     */
    public void setChi024(String chi024) {
        this.chi024 = chi024;
    }

    /**
     * 获取 chi024 数据指标类型(number、char、date)
     *
     * @return 数据指标类型(number 、 char 、 date)
     */
    public String getChi024() {
        return this.chi024;
    }

    /**
     * 设置 chi025 列表展示长度
     *
     * @param chi025 列表展示长度
     */
    public void setChi025(String chi025) {
        this.chi025 = chi025;
    }

    /**
     * 获取 chi025 列表展示长度
     *
     * @return 列表展示长度
     */
    public String getChi025() {
        return this.chi025;
    }

    /**
     * 设置 chi026 是否必填项
     *
     * @param chi026 是否必填项
     */
    public void setChi026(String chi026) {
        this.chi026 = chi026;
    }

    /**
     * 获取 chi026 是否必填项
     *
     * @return 是否必填项
     */
    public String getChi026() {
        return this.chi026;
    }

    /**
     * 设置 chi027 显示顺序
     *
     * @param chi027 显示顺序
     */
    public void setChi027(Long chi027) {
        this.chi027 = chi027;
    }

    /**
     * 获取 chi027 显示顺序
     *
     * @return 显示顺序
     */
    public Long getChi027() {
        return this.chi027;
    }

    /**
     * 设置 chi028 填写规范
     *
     * @param chi028 填写规范
     */
    public void setChi028(String chi028) {
        this.chi028 = chi028;
    }

    /**
     * 获取 chi028 填写规范
     *
     * @return 填写规范
     */
    public String getChi028() {
        return this.chi028;
    }

    /**
     * 设置 chi029 是否下拉选
     *
     * @param chi029 是否下拉选
     */
    public void setChi029(String chi029) {
        this.chi029 = chi029;
    }

    /**
     * 获取 chi029 是否下拉选
     *
     * @return 是否下拉选
     */
    public String getChi029() {
        return this.chi029;
    }

    /**
     * 转换为map对象
     *
     * @return Map
     */
    public java.util.Map toMap() {
        java.util.Map map = new java.util.HashMap();
        map.put("chi020", getChi020());    //数据指标id
        map.put("chi031", getChi031());    //服务事项编码
        map.put("chi021", getChi021());    //服务事项名称
        map.put("chi022", getChi022());    //数据指标名
        map.put("chi023", getChi023());    //数据指标注释
        map.put("chi024", getChi024());    //数据指标类型(number、char、date)
        map.put("chi025", getChi025());    //列表展示长度
        map.put("chi026", getChi026());    //是否必填项
        map.put("chi027", getChi027());    //显示顺序
        map.put("chi028", getChi028());    //填写规范
        map.put("chi029", getChi029());    //是否下拉选

        return map;
    }
}
