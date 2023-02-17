package com.xue.demo.algorithmApi.demo;

import java.util.LinkedList;

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

         */

    }
}
