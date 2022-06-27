package com.sy.paysystem.utils;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ExcelReader reader  = ExcelUtil.getReader("E:\\paysystem\\src\\main\\resources\\files\\工资表_双层表头.xlsx");
        List<List<Object>> read = reader.read();
        read.forEach(System.out::println);
    }
}
