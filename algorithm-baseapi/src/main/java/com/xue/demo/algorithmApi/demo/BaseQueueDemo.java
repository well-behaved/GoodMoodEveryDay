package com.xue.demo.algorithmApi.demo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: xuexiong@souche.com
 * @date: 2023/2/17 10:23
 * @description: 前提：如何用java 实现队列 数组 链表等  api熟悉
 * <p>
 * 如何使用java 实现队列
 */
public class BaseQueueDemo {
    public static void main(String[] args) {
        /*
        使用 LinkedArrayList 实现队列
         */
        LinkedList<String> queue = new LinkedList<>();
        //入队 add在链表尾部插入元素
        queue.add("入队");
        //出队  poll返回链表头部元素 并且删除
        queue.poll();
        //查看队尾 peek返回链表头部元素 但是不删除
        String queueLast = queue.peek();


        /*
            大顶堆 小顶堆实现
            java 优先队列默认为小顶堆
         */
        //小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //加入元素到堆中
        minHeap.offer(12321);
        //取出堆顶元素 但是不删除
        minHeap.peek();
        //取出堆顶元素 并且删除
        minHeap.poll();
        //大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->(o2.compareTo(o1)));


    }
}
