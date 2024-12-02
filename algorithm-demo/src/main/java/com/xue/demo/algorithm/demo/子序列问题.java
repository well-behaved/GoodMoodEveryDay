package com.xue.demo.algorithm.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 子序列问题 {
    public static void main(String[] args) {
        String word = "123";
        /*
            获取 返回所有的全排列
         */
        //字符串转数组
        List<Character> resultList = new ArrayList<>();
        //判断是否已经被使用 用一个set记录一下是否被使用过
        Set<Integer> hadUse = new HashSet<>();
        char[] chars = word.toCharArray();

        //返回所有的全排列
        getAllList(resultList,chars,hadUse);
        System.out.println("----------");
        //返回所有的排列 子排列也算
        getAllChildList(resultList,chars,hadUse);



    }
    /**
     * 递归获取所有的子序列
     * @param resultList
     * @param chars
     * @param i
     */
    private static void getAllChildList(List<Character> resultList
            , char[] chars, Set<Integer> hadUse) {
        System.out.println(resultList);
        //终结条件判断
        if (resultList.size() == chars.length) {
            //到达最终长度 返回
            return;
        }
        for (int j = 0; j < chars.length; j++) {
            if(hadUse.contains(j)){
                continue;
            }
            //添加本节点
            resultList.add(chars[j]);
            hadUse.add(j);
            //递归调用
            getAllChildList(resultList, chars, hadUse);
            //取出本节点
            resultList.remove(resultList.size() - 1);
            hadUse.remove(j);
        }
    }

    /**
     * 递归获取所有的全序列
     * @param resultList
     * @param chars
     * @param i
     */
    private static void getAllList(List<Character> resultList, char[] chars,Set<Integer> hadUse) {
        //终结条件判断
        if (resultList.size() == chars.length) {
            //到达最终长度 输出
            System.out.println(resultList);
            return;
        }

       for (int j = 0; j < chars.length; j++) {
           if(hadUse.contains(j)){
               continue;
           }
           //添加本节点
           resultList.add(chars[j]);
           hadUse.add(j);
           //递归调用
           getAllList(resultList, chars, hadUse);
           //取出本节点
           resultList.remove(resultList.size() - 1);
           hadUse.remove(j);
       }
    }
}
