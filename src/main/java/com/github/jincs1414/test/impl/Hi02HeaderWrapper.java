package com.github.jincs1414.test.impl;

import com.github.jincs1414.excel.wapper.CellWrapper;
import com.github.jincs1414.excel.wapper.RowWrapper;

import java.util.List;

/**
 * 定制化的表头数据
 */
public class Hi02HeaderWrapper extends RowWrapper<Hi02Domain> {

    public Hi02HeaderWrapper(List<Hi02Domain> hi02Domains) {
        super(hi02Domains,(hi02Domain)->
            new CellWrapper.Builder()
                    .setCode(hi02Domain.getChi022())
                    .setDesc(hi02Domain.getChi023())
                    .setRequire("1".equalsIgnoreCase(hi02Domain.getChi026()))
                    .setSelectInput("1".equalsIgnoreCase(hi02Domain.getChi029()))
                    .build()
        );
    }

    }
