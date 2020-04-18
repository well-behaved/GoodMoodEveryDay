package com.xue.demo.algorithm.demo;

/**
 * @author: xuexiong@souche.com
 * @date: 2020-04-16 17:23
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Demo3 {
    /*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    public static void main(String[] args) {
        System.out.println(getN(6));
    }

    private static int getN(int n) {
        if(n <= 1){
            return n;
        }
        return getN(n-1) + getN(n-2);
    }
}
