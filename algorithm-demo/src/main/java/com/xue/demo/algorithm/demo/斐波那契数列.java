package com.xue.demo.algorithm.demo;

import java.util.Date;

/**
 * @author: xuexiong@souche.com
 * @date: 2020-04-16 16:58
 * @description: 斐波那契数列
 * n阶楼梯上楼问题
 */
public class 斐波那契数列 {
    public static void main(String[] args) {
        //1、1、2、3、5、8、13、21、34....
        int n = 45;


        /*
        暴力递归
         */
        System.out.println("第几个数:" + n);
        Date dateBegin = new Date();
        int violence = violence(n);
        Date dateEnd = new Date();
        System.out.println("时间:" + (dateEnd.getTime() - dateBegin.getTime()) + "暴力求解+递归：" + violence);

        /*
        动态规划 循环
         */
        System.out.println("第几个数:" + n);
        Date dateBegin2 = new Date();
        int violence2 = circulate(n);
        Date dateEnd2 = new Date();
        System.out.println("时间:" + (dateEnd2.getTime() - dateBegin2.getTime()) + "动态规划+循环：" + violence2);




    }

    /**
     * 动态规划 循环
     * 状态转移方程: f(n) = f(n-1)+f(n-2)
     */
    private static int circulate(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        //记忆数组
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[nums.length - 1];
    }

    /**
     * 输出第n个斐波那契数列
     * 暴露递归
     *
     * @param
     * @return
     * @author xuexiong@souche.com  17:03 2020-04-16
     **/
    public static int violence(int n) {
        if (n <= 2) {
            return 1;
        }
        return violence(n - 1) + violence(n - 2);
    }
}
