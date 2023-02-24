package com.xue.demo.algorithm.demo;

/**
 * @author: xuexiong@souche.com
 * @date: 2020-04-16 17:23
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class 青蛙跳台阶 {
    /*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    public static void main(String[] args) {

        System.out.println("递归法:" + getN(6));
        System.out.println("动态规划法:" + dynamicProgramming(6));
    }

    /**
     * 递归写法
     *
     * @return
     * @throws
     * @author xuexiong@souche.com
     * @date 2022/3/22 14:57
     */
    private static int getN(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return getN(n - 1) + getN(n - 2);
    }

    /**
     * 动态规划写法
     *
     * @return
     * @throws
     * @author xuexiong@souche.com
     * @date 2022/3/22 14:57
     */
    private static int dynamicProgramming(int n) {
        int[] nums = new int[n + 2];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i < n + 2; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n + 1];
    }
}
