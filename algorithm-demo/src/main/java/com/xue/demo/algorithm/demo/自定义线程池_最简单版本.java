package com.xue.demo.algorithm.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 类似一个生产者消费模型
 * - 本版本没有懒加载功能
 * - 任务满了则阻塞主线程
 */
public class 自定义线程池_最简单版本 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPoll myThreadPoll = new MyThreadPoll(5,10);
        for (int i = 0; i < 100; i++) {
            int num = i;
            Runnable demo = ()->{
                try {
                    //任务执行时间模拟
                    Thread.sleep(new Random().nextInt(200) + 30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("任务"+num);
            };
            //添加任务
            Thread.sleep(new Random().nextInt(30) + 3);
            myThreadPoll.addTask(demo);
        }


        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

/**
 * 线程池类
 */
class MyThreadPoll {
    /**
     * 线程池
     */
    public List<MyThread> threadList;
    /**
     * 核心线程数量
     */
    public int maxThreadNum;
    /**
     * 任务队列数量
     */
    public int maxThreadTaskNum;
    /**
     * 任务队列
     * 自己简单实现一个阻塞队列 任务的获取和添加都加锁就好
     */
    public LinkedList<Runnable> taskList;

    public MyThreadPoll(int maxThreadNum,int maxThreadTaskNum) {
        this.maxThreadNum = maxThreadNum;
        this.maxThreadTaskNum = maxThreadTaskNum;
        taskList = new LinkedList<>();
        //初始化线程池
        threadList = new ArrayList<>(maxThreadNum);
        for (int i = 0; i < maxThreadNum; i++) {
            MyThread myThread = new MyThread(taskList, "线程" + i);
            //设置为守护线程 便于测试 实际一般设置为false
            myThread.setDaemon(true);
            //启动核心线程
            myThread.start();
            threadList.add(myThread);
        }


    }

    public void addTask(Runnable oneTask) throws InterruptedException {
        synchronized (taskList) {
            while (taskList.size() >= maxThreadTaskNum) {
                System.out.println("任务队列满了");
                taskList.wait();
            }
            taskList.add(oneTask);
            taskList.notifyAll();
        }
    }

    /**
     * 工作线程
     */
    private static class MyThread extends Thread{
        private LinkedList<Runnable> taskList;
        private String threadName;

        public MyThread(LinkedList<Runnable> taskList, String threadName) {
            this.taskList = taskList;
            this.threadName = threadName;
        }

        public void run() {
            System.out.println("线程"+threadName+"启动");
            while (true) {
                Runnable oneTask = null;
                synchronized (taskList) {
                    while (taskList.size() == 0) {
                        try {
                            System.out.println("线程："+threadName+"wait");
                            taskList.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    oneTask = taskList.poll();
                    taskList.notifyAll();
                }
                System.out.println("线程"+threadName+"任务执行");
                oneTask.run();
            }
        }
    }
}
