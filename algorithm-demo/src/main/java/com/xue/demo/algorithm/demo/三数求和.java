package com.xue.demo.algorithm.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class 三数求和 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1,2,3,4,2,-1,-3,-1,0}));
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
        if (nums == null || nums.length < 3) {
            return resultList;
        }
        //排序
        Arrays.sort(nums);

        //去重
        int beforeOne = nums[0] - 1;


        //开始处理 第一个指针是i
        for (int oneIndex = 0; oneIndex < nums.length - 2; oneIndex++) {
            if (beforeOne == nums[oneIndex]) {
                //之前已经走过 跳过
                continue;
            }
            beforeOne = nums[oneIndex];

            int twoIndex = oneIndex + 1;
            int threeIndex = nums.length - 1;

            //角标是否移动过
            boolean twoIndexChange = false;
            boolean threeIndexChange = false;


            while (threeIndex > twoIndex) {
                if (twoIndexChange && nums[twoIndex] == nums[twoIndex - 1]) {
                    twoIndex++;
                    continue;
                }
                if (threeIndexChange && nums[threeIndex] == nums[threeIndex + 1]) {
                    threeIndex--;
                    continue;
                }
                twoIndexChange = false;
                threeIndexChange = false;


                if (nums[twoIndex] + nums[threeIndex] > -nums[oneIndex]) {
                    //结果大了 那么往左移动
                    threeIndex--;
                    threeIndexChange = true;
                } else if (nums[twoIndex] + nums[threeIndex] < -nums[oneIndex]) {
                    // 结果小 往右移
                    twoIndex++;
                    twoIndexChange = true;
                } else {
                    resultList.add(Arrays.asList(nums[oneIndex], nums[twoIndex]
                            , nums[threeIndex]));
                    twoIndex++;
                    threeIndex--;
                    twoIndexChange = true;
                    threeIndexChange = true;
                }
            }
        }
        return resultList;
    }

}
