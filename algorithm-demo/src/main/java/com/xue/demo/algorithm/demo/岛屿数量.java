package com.xue.demo.algorithm.demo;

import java.util.HashSet;

/**
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 */
public class 岛屿数量 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'0','1','0'},
                {'1','0','1'},
                {'0','1','0'}
        };
        int num = numIslands(grid);

        System.out.println(num);
    }

    /**
     * 有 1 就开始遍历 ，并且用hashMap存储已经遍历过的1的角标，最后统计1的数量
     */
    public static int numIslands(char[][] grid) {
        int numIslands = 0;
        if (grid == null || grid.length == 0) {
            return numIslands;
        }
        //已经遍历过的1 的 角标  
        HashSet<String> hadReadOneSet = new HashSet<>();


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    //不是岛屿跳过
                    continue;
                }
                if (hadReadOneSet.contains(i + "," + j)) {
                    //已经遍历过
                    continue;
                }
                //是 没有遍历过的岛屿 遍历并且标记
                //深度遍历吧 标记岛屿
                leadSearch(grid, i, j, hadReadOneSet);

                numIslands = numIslands + 1;
            }
        }
        return numIslands;
    }

    public static void leadSearch(char[][] grid, int i, int j, HashSet<String> hadReadOneSet) {
        if (i >= grid.length || j >= grid[0].length
                || i < 0 || j < 0
                || grid[i][j] == '0'
                || hadReadOneSet.contains(i + "," + j)) {
            //到边界结束
            return;
        }
        //当前位置
        hadReadOneSet.add(i + "," + j);
        //遍历右边
        leadSearch(grid, i, j + 1, hadReadOneSet);
        //遍历下边
        leadSearch(grid, i + 1, j, hadReadOneSet);
        //遍历左边
        leadSearch(grid, 1, j - 1, hadReadOneSet);
        //遍历上面
        leadSearch(grid, i - 1, j, hadReadOneSet);
    }
}