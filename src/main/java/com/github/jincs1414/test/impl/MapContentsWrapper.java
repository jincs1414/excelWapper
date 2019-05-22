package com.github.jincs1414.test.impl;

import com.github.jincs1414.excel.wapper.CellWrapper;
import com.github.jincs1414.excel.wapper.RowWrapper;
import com.github.jincs1414.excel.wapper.RowsWapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 定制化的内容数据
 */
public class MapContentsWrapper extends RowsWapper<Map> {

    public MapContentsWrapper(List<Map> contents) {
        super(contents);
    }

    //自定义的数据提取规则
    @Override
    public void apply(RowWrapper header) {
        List<RowWrapper> rows = getContents().stream().map(map -> {
            CellWrapper cellWrapper;
            RowWrapper row = new RowWrapper();
            for (Object cell : header.getCells()) {
                cellWrapper = (CellWrapper) cell;
                row.addCell(new CellWrapper.Builder()
                        .setCode(cellWrapper.getCode())
                        .setDesc((String) Optional.ofNullable(map.get(cellWrapper.getCode())).orElse(""))
                        .build()
                );
            }
            return row;
        }).collect(Collectors.toList());
        setRowWrappers(rows);
    }
}
