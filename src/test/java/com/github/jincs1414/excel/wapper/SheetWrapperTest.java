package com.github.jincs1414.excel.wapper;

import com.github.jincs1414.test.impl.Hi02Domain;
import com.github.jincs1414.test.impl.Hi02HeaderWrapper;
import com.github.jincs1414.test.impl.MapContentsWrapper;
import com.google.common.collect.ImmutableMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SheetWrapperTest {

    @Test
    public void writeTo() throws FileNotFoundException {
        Hi02Domain hi02Domain = new Hi02Domain();
        hi02Domain.setChi022("aac002");
        hi02Domain.setChi023("身份证号");
        hi02Domain.setChi026("1");

        Hi02Domain hi02Domain2 = new Hi02Domain();
        hi02Domain2.setChi022("aac003");
        hi02Domain2.setChi023("姓名");
        hi02Domain2.setChi026("1");

        Hi02Domain hi02Domain3 = new Hi02Domain();
        hi02Domain3.setChi022("phone");
        hi02Domain3.setChi023("电话");

        List<Hi02Domain> hi02DomainList = Arrays.asList(
                hi02Domain,hi02Domain2,hi02Domain3
        );

        List<Map> contents = Arrays.asList(
                ImmutableMap.of("aac002","111111","aac003","测试1"),
                ImmutableMap.of("aac002","222222","aac003","测试2"),
                ImmutableMap.of("aac002","3333333","aac003","测试3","phone","17761270293")

        );
        SheetWrapper sheetWrapper = new SheetWrapper.Builder()
                .createSheet(HSSFWorkbook.class)
                .setHeader(new Hi02HeaderWrapper(hi02DomainList))
                .setContents(new MapContentsWrapper(contents))
                .build();
        OutputStream outputStream = new FileOutputStream("E://55.xls");
        sheetWrapper.writeTo(outputStream)
                .closeStream();
    }
}