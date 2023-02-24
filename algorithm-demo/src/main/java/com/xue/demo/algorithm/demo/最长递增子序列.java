package com.xue.demo.algorithm.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @author: xuexiong@souche.com
 * @date: 2023/2/23 14:20
 * @description:最长递增子序列长度
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(200);
        }
        System.out.println("数组长度:" + array.length);
        System.out.println("数组内容:" + Arrays.toString(array));
        /*
        最长递增子序列 暴力循环

        根据  violence(i) =  max(violence(i+1),violence(i+2)...)+1; 递归

         */
        for (int i = 0; i < 10000; i++) {
            //程序预热 方便下方时间准备
        }

        Date dateBegin = new Date();
        int violence = violence(array);
        Date dateEnd = new Date();
        System.out.println("时间:" + (dateEnd.getTime() - dateBegin.getTime()) + "暴力求解+递归：" + violence);

        /*
            进行 剪枝运算 去除重复的运算 递归写法
            剪枝也就是动态规划
         */
        Date dateBegin2 = new Date();
        int violence2 = recurrence(array);
        Date dateEnd2 = new Date();
        System.out.println("时间:" + (dateEnd2.getTime() - dateBegin2.getTime()) + "剪枝+递归：" + violence2);

        /*
            循环写法
            进行 剪枝运算 去除重复的运算 方便计算时间复杂度
            剪枝也就是动态规划
         */
        Date dateBegin3 = new Date();
        int violence3 = circulate(array);
        Date dateEnd3 = new Date();
        System.out.println("时间:" + (dateEnd3.getTime() - dateBegin3.getTime()) + "剪枝+循环：" + violence3);


    }

    /**
     * 最终写法 循环实现
     * <p>
     * violence(i) =  max(violence(i+1),violence(i+2)...)+1;
     *
     * @return
     * @throws
     * @author xuexiong@souche.com
     * @date 2023/2/24 10:40
     */
    private static int circulate(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }
        int[] violence = new int[array.length];
        violence[array.length - 1] = 1;
        for (int i = array.length - 2; i >= 0; i--) {
            int max = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[i] && violence[j] + 1 > max) {
                    max = violence[j] + 1;
                }
            }
            violence[i] = max;
        }
        return Arrays.stream(violence).max().orElse(1);
    }

    /**
     * 动态规划 递归版
     * 又称剪枝运算
     *
     * @param array
     * @return
     */
    private static int recurrence(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }
        /*
            暴力遍历
         */
        //记录 算过的位置的值
        int[] maxViolence = new int[array.length];
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int violenceI = recurrence(array, i, maxViolence);
            if (violenceI > max) {
                max = violenceI;
            }
        }
        return max + 1;
    }

    /**
     * 递归
     *
     * @param maxRecurrence i位置 为之前计算过的数据
     * @return
     * @throws
     * @author xuexiong@souche.com
     * @date 2023/2/23 18:16
     */
    private static int recurrence(int[] array, int i, int[] maxRecurrence) {
        if (i == array.length) {
            return 1;
        }
        if (maxRecurrence[i] != 0) {
            //如果之前计算过则 直接返回 防止重复计算 也就是剪枝
            return maxRecurrence[i];
        }
        int max = 0;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] > array[i]) {
                int violenceJ = violence(array, j) + 1;
                maxRecurrence[j] = violenceJ;
                if (violenceJ > max) {
                    max = violenceJ;
                }
            }
        }
        return max;
    }

    /**
     * 尝试暴力求解
     *
     * @return
     * @throws
     * @author xuexiong@souche.com
     * @date 2023/2/23 14:23
     */
    private static int violence(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }
        /*
            暴力遍历
         */
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int violenceI = violence(array, i);
            if (violenceI > max) {
                max = violenceI;
            }
        }
        return max + 1;
    }

    /*
        暴力遍历
        violence(i) =  max(violence(i+1),violence(i+2)...)+1;
     */
    private static int violence(int[] array, int i) {
        if (i == array.length) {
            return 1;
        }
        int max = 0;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] > array[i]) {
                int violenceJ = violence(array, j) + 1;
                if (violenceJ > max) {
                    max = violenceJ;
                }
            }
        }
        return max;
    }
}
