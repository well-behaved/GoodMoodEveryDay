package com.xue.demo.algorithm.demo;

import java.util.Arrays;

/**
 * 最大子数组的和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class 最大子数组的和 {
    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        //基本参数校验
        if(nums == null || nums.length==0){
            return 0;
        }
        //记忆一维数组
        int[] iMax = new int[nums.length];
        iMax[nums.length-1] = nums[nums.length-1];

        //动态规划尝试 f(i) = f(i+1)>0?f(i+1)+f(i):f(i);
        for(int i= nums.length-2 ; i>0 ; i--){
            if(iMax[i+1]>0){
                iMax[i] = iMax[i+1]+nums[i];
            }else{
                iMax[i] = nums[i];
            }
        }
        //获取最大值
        return Arrays.stream(nums).max().orElse(0);

    }
}