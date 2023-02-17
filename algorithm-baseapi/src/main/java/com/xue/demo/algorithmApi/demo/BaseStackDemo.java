package com.xue.demo.algorithmApi.demo;

import java.util.LinkedList;

/**
 * @author: xuexiong@souche.com
 * @date: 2023/2/17 10:32
 * @description:前提：如何用java 实现队列 数组 链表等  api熟悉
 * 如何用java 实现栈
 */
public class BaseStackDemo {
    public static void main(String[] args) {
        /*
        使用 LinkedArrayList 实现栈
         */
        LinkedList<String> stack = new LinkedList<>();
        //压栈 addFirst添加到链表头部
        stack.addFirst("压栈");

        //弹栈 poll返回链表头部元素 并且删除
        String poll = stack.poll();

        //查看栈顶元素 peek返回链表头部元素 但是不删除
        String peek = stack.peek();

    }
}
