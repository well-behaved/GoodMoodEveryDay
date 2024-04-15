package com.xue.demo.algorithm.demo;

public class 接雨水 {
    public static void main(String[] args) {
        int trap = trap(new int[]{4, 2, 0, 3, 2, 5});
        System.out.println(trap+"--------");

    }
    public static int trap(int[] height) {
        /*
            每个位置可以存储的水的量 等于min(左侧最高值,右侧最高值)-当前柱子的高度
        */
        //存储当前位置左侧的最高值
        int[] heightLeft = new int[height.length];
        heightLeft[0] = height[0];
        for(int i = 1;i<heightLeft.length;i++){
            if(height[i] > heightLeft[i-1]){
                heightLeft[i] =  height[i];
            }else{
                heightLeft[i] = heightLeft[i-1];
            }
        }
        //存储当前位置右侧的最高值
        int[] heightRight = new int[height.length];
        heightRight[height.length -1] = height[height.length -1];
        for(int i = height.length -2;i>=0;i--){
            if(height[i] > heightRight[i+1]){
                heightRight[i] =  height[i];
            }else{
                heightRight[i] = heightRight[i+1];
            }
        } 

        //计算所有值
        int sum = 0;
        for (int i = 0;i<height.length;i++){
            int maxLeftOrRight = Math.min(heightRight[i],heightLeft[i]);
            if(maxLeftOrRight > height[i]){
                sum = sum + maxLeftOrRight-height[i];
            }
        }
        return sum;
        
    

    }
}