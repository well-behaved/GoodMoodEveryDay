package com.xue.demo.algorithmApi.demo;

/**
 * string 类型 手撕算法常用方法
 */
public class BaseStringDemo {
    public static void main(String[] args) {
        String demoString = "demoString";
        // string 转 char数组
        char[] charArray = demoString.toCharArray();
        // string 分割
        String[] split = demoString.split(",");
        // string 分割字符串
        String substring = demoString.substring(0, 2);
        //字符串匹配
        int demo = demoString.indexOf("String");
    }
}

