package com.github.jincs1414.excel.wapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 表头和行数据的包装类
 */
public  class RowWrapper<T>{
    /**
     * 包装后的单元格数据
     */
    private List<CellWrapper> cells = new ArrayList<CellWrapper>();

    /**
     *
     * @param header
     * @param function 提取规则
     */
    public RowWrapper(List<T> header, Function<T, CellWrapper> function) {
        for (T m : header) {
            this.cells.add(function.apply(m));
        }
    }

    public RowWrapper() {
    }

    /**
     * 添加包装的单元格到集合
     * @param cellWrapper
     */
    public void addCell(CellWrapper cellWrapper){
        cells.add(cellWrapper);
    }

    /**
     * 获取所有包装的单元格集合
     * @return
     */
    public List<CellWrapper> getCells() {
        return cells;
    }
}
