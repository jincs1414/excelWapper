package com.github.jincs1414.excel.wapper;

import java.util.Iterator;
import java.util.List;

/**
 * 表格行数据的包装类
 * @param <T>
 */
public abstract class RowsWapper<T> implements Iterable{
    /**
     * 包装后的数据
     */
    private List<RowWrapper> rowWrappers;
    /**
     * 原始的数据
     */
    private List<T> contents;

    public RowsWapper(List<T> contents) {
        this.contents = contents;
    }

    @Override
    public Iterator<T> iterator() {
        return this.contents.iterator();
    }

    public void setRowWrappers(List<RowWrapper> rowWrappers) {
        this.rowWrappers = rowWrappers;
    }

    public void setContents(List<T> contents) {
        this.contents = contents;
    }

    public List<RowWrapper> getRowWrappers() {
        return rowWrappers;
    }

    public List<T> getContents() {
        return contents;
    }

    /**
     * 将表头和数据内容关联起来，实现对应关系
     * @param header
     */
    public abstract void apply(RowWrapper header);
}
