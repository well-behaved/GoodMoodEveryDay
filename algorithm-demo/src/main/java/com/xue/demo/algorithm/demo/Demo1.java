package com.xue.demo.algorithm.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuexiong@souche.com
 * @date: 2020-04-15 20:46
 * @description: 并查集
 */
public class Demo1 {
    /**
     * 求子集
     * 输入： nums = [1,2,3]
     * 输出：
     * [
     * [3],
     *      [1],
     *      [2],
     *      [1,2,3],
     *      [1,3],
     *      [2,3],
     *      [1,2],
     *      []
     * ]
     * <p>
     *
     * @return
     */
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        List<List<Integer>> lists = subsets(numbers);
        System.out.println(lists);

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allList = new ArrayList<>();
        add(allList, nums.length, nums);
        //加入空集
        allList.add(new ArrayList<>());
        return allList;
    }

    /**
     * @param allList 所有集
     * @return
     * @author xuexiong@souche.com  20:55 2020-04-15
     **/
    public static void add(List<List<Integer>> allList, int index, int[] nums) {
        if (index == 0) {
            return;
        }
        int tempIndex = index - 1;
        add(allList, tempIndex, nums);
        //加入自己
        ArrayList<Integer> salf = new ArrayList<>();
        Integer value = nums[tempIndex];
        salf.add(value);
        allList.add(salf);
        //加入其他人
        if (allList.size() == 1) {
            return;
        }
        List<List<Integer>> tempList = new ArrayList<>(allList);
        for (int i = 0; i < tempList.size() - 1; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>(tempList.get(i));
            arrayList.add(value);
            allList.add(arrayList);
        }
        return;
    }
}
