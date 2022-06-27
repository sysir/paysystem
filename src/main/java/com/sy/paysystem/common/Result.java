package com.sy.paysystem.common;

import lombok.Data;

@Data
public class Result<T> {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;
}
