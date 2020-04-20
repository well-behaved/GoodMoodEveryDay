package com.xue.demo.algorithm.demo;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author: xuexiong@souche.com
 * @date: 2020-04-18 17:38
 * @description: 动态规划入门
 */
public class Demo6 {
    private static Integer excuNums = 1;

    public static void main(String[] args) {
        /*
        数字三角形(POJ1163)
    在上面的数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。路径上的每一步都只能往左下或 右下走
。只需要求出这个最大和即可，不必给出具体路径。 三角形的行数大于1小于等于100，数字为 0 - 99

    输入格式：

                  7

                3   8

              8   1   0

            2   7   4   4

          4   5   2   6   5

    要求输出最大和
      */
        Integer[][] triangle = {
                {7}
                , {3, 8}
                , {8, 1, 0}
                , {2, 7, 4, 4}
                , {4, 5, 2, 6, 5}
                , {4, 5, 2, 6, 5, 23}
                , {4, 5, 2, 6, 5, 1, 12}
                , {4, 5, 2, 6, 5, 3, 1, 0}
                , {4, 5, 2, 6, 5, 3, 1, 0, 23}
                , {4, 5, 2, 6, 5, 3, 1, 0, 12, 2}
                , {4, 5, 2, 6, 5, 3, 1, 0, 23, 43, 2}
                , {4, 5, 2, 6, 5, 3, 1, 0, 1, 32, 45, 12}
        };
        //普通做法
        maxCommon(triangle);
    }

    /**
     * 递归解法 普通
     * 思路：i为行 j为列 那么f(i,j)=max(f(i-1,j)+int[i][j],f(i,j)+int[i][j])
     *
     * @param
     * @return
     * @author xuexiong@souche.com  15:46 2020-04-20
     **/
    private static void maxCommon(Integer[][] triangle) {
        //第一步 求出最后一行的所有最大值
        Integer[] maxNum = new Integer[triangle[triangle.length - 1].length];
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            maxNum[i] = recursion(triangle, triangle.length - 1, i);
        }
        System.out.println(intMax(maxNum));
    }

    /**
     * @param
     * @return
     * @author xuexiong@souche.com  17:40 2020-04-18
     **/
    public static Integer recursion(Integer[][] triangle, int i, int j) {
        System.out.println("运行" + excuNums++ + "次");
        if (i == 0) {
            //如果是第一行
            return triangle[i][j];
        }
        if (j == 0) {
            //如果是每行第一个
            return recursion(triangle, i - 1, j) + triangle[i][j];
        }
        if (j == triangle[i].length - 1) {
            //如果是每行最后一个
            return recursion(triangle, i - 1, j - 1) + triangle[i][j];
        }
        int leftMax = recursion(triangle, i - 1, j - 1);
        int rightMax = recursion(triangle, i - 1, j);
        return leftMax > rightMax ? leftMax + triangle[i][j] : rightMax + triangle[i][j];
    }

    /**
     * 返回一个数组的最大值
     *
     * @param
     * @return
     * @author xuexiong@souche.com  11:33 2020-04-20
     **/
    private static int intMax(Integer[] ints) {
        return Collections.max(Arrays.asList(ints));
    }
}
