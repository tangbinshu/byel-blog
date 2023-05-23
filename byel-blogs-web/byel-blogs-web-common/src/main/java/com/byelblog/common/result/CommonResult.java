package com.byelblog.common.result;

import lombok.Data;

import java.util.List;
@Data
public class CommonResult<T> {
    private  String code;
    private List<T> data;
    private  Integer total;

    public CommonResult(String code,List<T> data,Integer total) {
        this.code = code;
        this.data = data;
        this.total = total;
    }
}
