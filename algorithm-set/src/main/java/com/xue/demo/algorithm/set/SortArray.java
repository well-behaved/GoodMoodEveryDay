package com.xue.demo.algorithm.set;

import java.util.Arrays;

/**
 * @author: xuexiong@souche.com
 * @date: 2020-04-20  15:55
 * @description: 各种排序算法
 */
public class SortArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 4};
        //插入排序
        sortInsert(array);
        System.out.println(Arrays.toString(array));
        //快速排序
        int[] array2 = {1, 2, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 4};
        fastSort(array2, 0, array.length - 1);
        System.out.println(Arrays.toString(array2));

    }

    /**
     * 快速排序
     * <p>
     * 过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小
     * ，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行
     * ，以此达到整个数据变成有序序列。
     *
     * @param
     * @return
     * @author xuexiong@souche.com  17:13 2020-04-20
     **/
    private static void fastSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        //选定基准 从左边开始吧
        int baseNum = array[leftIndex];
        int leftIndexNow = leftIndex;
        int rightIndexNow = rightIndex;
        while (leftIndexNow < rightIndexNow) {
            //找到左边第一个大于基准值的
            while (array[leftIndexNow] <= baseNum && leftIndexNow < rightIndexNow) {
                leftIndexNow++;
            }
            //找到右边第一个小于基准值的
            while (array[rightIndexNow] >= baseNum && leftIndexNow < rightIndexNow) {
                rightIndexNow--;
            }
            //交换位置
            if (leftIndexNow < rightIndexNow) {
                int temp = array[leftIndexNow];
                array[leftIndexNow] = array[rightIndexNow];
                array[rightIndexNow] = temp;
            }
        }
        //基准找到位置
        array[leftIndex] = array[leftIndexNow];
        array[leftIndexNow] = baseNum;
        //递归左边
        fastSort(array, leftIndex, leftIndexNow - 1);
        //递归右边
        fastSort(array, leftIndexNow + 1, rightIndex);
    }

    /**
     * 插入排序
     *
     * @param
     * @return
     * @author xuexiong@souche.com  16:23 2020-04-20
     **/
    private static void sortInsert(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int insertNum = array[i];
            int j = i - 1;
            //和前一个比较 如果小于则互换位置,类似往前挪一位
            while (j >= 0 && insertNum < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertNum;
        }

    }
}
