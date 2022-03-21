package com.xue.demo.algorithm.demo;

/**
 * @author: xuexiong@souche.com
 * @date: 2020-04-16 16:58
 * @description: 斐波那契数列
 */
public class Demo2 {
    public static void main(String[] args) {
        //1、1、2、3、5、8、13、21、34....
        System.out.println(getN(1));
        System.out.println(getN(2));
        System.out.println(getN(3));
        System.out.println(getN(4));
        System.out.println(getN(5));
        System.out.println(getN(6));
        System.out.println(getN(7));
        System.out.println(getN(8));
        System.out.println(getN(9));
        System.out.println(getN(10));
        System.out.println(getN(11));
        System.out.println(getN(12));
        System.out.println(getN(13));
    }

    /**
     * 输出第n个斐波那契数列
     *
     * @param
     * @return
     * @author xuexiong@souche.com  17:03 2020-04-16
     **/
    public static int getN(int n) {
        if (n <= 2) {
            return 1;
        }
        return getN(n - 1) + getN(n - 2);
    }
}
