package com.xue.demo.algorithm.set;

import java.util.Arrays;

/**
 * @author: xuexiong@souche.com
 * @date: 2020-04-20  15:55
 * @description: 各种排序算法
 */
public class SortArray {
    public static void main(String[] args) {
        int k = 0;
        int[] array = {1, 2, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 4};
        //插入排序
        sortInsert(array);
        System.out.println("插入排序" + Arrays.toString(array));


        //快速排序
        int[] array2 = {1, 2, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 4};
        fastSort(array2, 0, array.length - 1);
        System.out.println("快速排序" + Arrays.toString(array2));

        //冒泡排序
        int[] array3 = {1, 2, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 4};
        bubbleSort(array3);
        System.out.println("冒泡排序" + Arrays.toString(array3));

        //选择排序
        int[] array4 = {1, 2, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 4};
        selectSort(array4);
        System.out.println("选择排序" + Arrays.toString(array4));


        //希尔排序
        int[] array5 = {1, 2, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 4};
        shellSort(array5);
        System.out.println("希尔排序" + Arrays.toString(array5));

        //归并排序
        int[] array6 = {1, 2, 34, 23, 1, 34, 53, 1, 23
                , 6, 7, 43, 123, 4};
        mergeSort(array6);
        System.out.println("归并排序" + Arrays.toString(array6));


    }

    /**
     * 归并排序
     * 分治 分组 然后组内排 然后合并分组
     *
     * @return
     * @throws
     * @author xuexiong@souche.com
     * @date 2022/3/21 10:18
     */
    public static void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * 归并排序
     *
     * @return
     * @throws
     * @author xuexiong@souche.com
     * @date 2022/3/21 17:10
     */
    private static void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        // 左边
        mergeSort(array, low, mid);
        // 右边
        mergeSort(array, mid + 1, high);
        // 左右归并
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = array[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            array[k2 + low] = temp[k2];
        }
    }

    /**
     * 希尔排序
     * <p>
     *
     * @return
     * @throws
     * @author xuexiong@souche.com
     * @date 2022/3/21 10:18
     */
    public static void shellSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        //步长
        int between = array.length;
        while (between != 1) {
            between = between / 2;
            for (int i = 0; i < array.length - between; i++) {
                //交换 排序
                int temp = array[i];
                int j = i + between;
                for (; j < array.length; j += between) {
                    if (array[j] < array[j - between]) {
                        array[j] = array[j - between];

                    }
                }
                array[j - between] = temp;
            }
        }

    }

    /**
     * 选择排序
     * <p>
     * 选择排序 先找第一个位置最小的，然后第二位置最小的。依次类推，也就是按照位置找数
     *
     * @return
     * @throws
     * @author xuexiong@souche.com
     * @date 2022/3/21 10:18
     */
    public static void selectSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            //i 位置 应该放置最小的数，初始值默认为i
            int tempIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                //找到tempIndex位置应该对应的数字
                if (array[tempIndex] >= array[j]) {
                    tempIndex = j;
                }
            }
            //此时tempValue位置为当前 为最小值。交换到i位置即可
            int tempValue = array[tempIndex];
            array[tempIndex] = array[i];
            array[i] = tempValue;
        }

    }

    /**
     * 冒泡排序
     *
     * @return
     * @throws
     * @author xuexiong@souche.com
     * @date 2022/3/18 17:21
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < array.length - i - 1; k++) {
                if (array[k] >= array[k + 1]) {
                    int temp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = temp;
                }
            }
        }
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
        if (leftIndex > rightIndex) {
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
            while (array[rightIndexNow] > baseNum && leftIndexNow < rightIndexNow) {
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
