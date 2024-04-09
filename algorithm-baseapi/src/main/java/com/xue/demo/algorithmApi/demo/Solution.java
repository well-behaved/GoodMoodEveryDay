package com.xue.demo.algorithmApi.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        threeSum(new int[]{1,-1,-1,0});

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        /*
            -----
            暴力求解 三次循环 n3
            -----
           遇数组不决，想想动态规划或者排序
           动态规划不好使，那么排序
           排序后可以天然避免重复问题，因为已经拍好序了，使用三个指针循环就好
        */
        //返回值准备 入参判断
        List<List<Integer>> resultList = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return resultList;
        }
        //排序
        Arrays.sort(nums);

        //去重
        int beforeOne = nums[0]-1;


        //开始处理 第一个指针是i
        for(int oneIndex = 0;oneIndex < nums.length - 2;oneIndex++){
            if(beforeOne == nums[oneIndex]){
                //之前已经走过 跳过
                continue;
            }
            beforeOne = nums[oneIndex];

            int twoIndex = oneIndex + 1;
            int threeIndex = nums.length-1;

            int beforeTwo = nums[twoIndex]-1;
            int beforethree = nums[threeIndex]-1;

            while(threeIndex > twoIndex){
                if(beforeTwo == nums[twoIndex]){
                    beforeTwo++;
                    continue;
                }
                if(beforethree == nums[threeIndex]){
                    threeIndex--;
                    continue;
                }
                beforeTwo = nums[twoIndex];
                beforethree = nums[threeIndex];

                if(nums[twoIndex] + nums[threeIndex] > -nums[oneIndex]){
                    //结果大了 那么往左移动
                    threeIndex--;
                }else if(nums[twoIndex] + nums[threeIndex] < -nums[oneIndex]){
                    // 结果小 往右移
                    twoIndex++;
                }else {
                    resultList.add(Arrays.asList(nums[oneIndex],nums[twoIndex]
                            ,nums[threeIndex]));
                    twoIndex++;
                    threeIndex--;
                }
            }
        }
        return resultList;
    }

}