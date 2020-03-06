package com.xue.demo.algorithm.bean;
/*
 * 用LinkedList模拟队列这一数据结构
 * 创建一个容器，对外提供可以使用容器的对象(调用容器中封装的方法)
 */

import java.util.LinkedList;

public class QueueBean<T> {
    /**
     * 存储数据
     */
    private LinkedList<T> link;

    public QueueBean() {
        link = new LinkedList<T>();
    }

    /**
     * 从尾部填入
     * @author xuexiong@souche.com  21:49 2020-03-06
     * @param 
     * @return 
     **/
    public void add(T obj) {
        link.offerLast((obj));
    }

    /**
     * 从头部获取
     * @author xuexiong@souche.com  21:49 2020-03-06
     * @param 
     * @return 
     **/
    public T get() {
        return link.pollFirst();
    }

    public boolean isNull() {
        return link.isEmpty();
    }
}
