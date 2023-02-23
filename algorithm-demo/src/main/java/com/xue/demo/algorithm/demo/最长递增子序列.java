package com.xue.demo.algorithm.demo;

import java.util.Date;

/**
 * @author: xuexiong@souche.com
 * @date: 2023/2/23 14:20
 * @description:最长递增子序列长度
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] array = {1, 2, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 4, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123,};
        /*
        最长递增子序列 暴力循环

        根据  violence(i) =  max(violence(i+1),violence(i+2)...)+1; 递归

         */
        for (int i = 0; i < 10000; i++) {
            //程序预热
        }

        Date dateBegin = new Date();
        int violence = violence(array);
        Date dateEnd = new Date();
        System.out.println("时间:" + (dateEnd.getTime() - dateBegin.getTime()) + "暴力求解+递归：" + violence);

        /*
            进行 剪枝运算 去除重复的运算
            剪枝也就是动态规划
         */
        Date dateBegin2 = new Date();
        int violence2 = recurrence(array);
        Date dateEnd2 = new Date();
        System.out.println("时间:" + (dateEnd2.getTime() - dateBegin2.getTime()) + "剪枝+递归：" + violence2);

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

    private static int recurrence(int[] array, int i, int[] maxViolence) {
        if (i == array.length) {
            return 1;
        }
        if (maxViolence[i] != 0) {
            System.out.println("--"+i);
            return maxViolence[i];
        }
        int max = 0;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] > array[i]) {
                int violenceJ = violence(array, j) + 1;
                maxViolence[j] = violenceJ;
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
