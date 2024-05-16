package com.xue.demo.algorithmApi.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * map常用 api
 */
public class BaseMapDemo {
    public static void main(String[] args) {
        //遍历 map
        Map<Integer,Integer> demoMap = new HashMap<>();
        demoMap.put(1,3);
        for(Integer oneKey : demoMap.keySet()){
            System.out.printf(demoMap.get(oneKey)+"");
        }
    }
}
