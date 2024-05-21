package com.xue.demo.algorithm.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 阻塞队列 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
        Runnable putThread = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    myQueue.put(new Random().nextInt());
                }

            }
        };
        Runnable getThread = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    myQueue.get();
                }
            }
        };
        new Thread(putThread).start();
        new Thread(getThread).start();

    }
}

class MyQueue {
    private List<Integer> dataArray = new ArrayList<>();
    //最大数量
    private int maxNum;
    private int dateSizeNow = 0;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition putCondition = reentrantLock.newCondition();
    private Condition getCondition = reentrantLock.newCondition();

    public MyQueue(int maxNum) {
        this.maxNum = maxNum;
    }

    public void put(Integer value) {
        try {
            reentrantLock.lock();
            while (dateSizeNow == maxNum) {
                //放满了
                System.out.println("添加 加锁");
                putCondition.await();
            }
            dateSizeNow++;
            dataArray.add(value);
            System.out.println("添加后数量:"+dateSizeNow);
            getCondition.signal();
        } catch (Exception e) {
            // todo
        } finally {
            reentrantLock.unlock();
        }
    }

    public void get() {
        try {
            reentrantLock.lock();
            while (dateSizeNow == 0) {
                System.out.println("消费 加锁");
                //拿完了
                getCondition.await();
            }
            dateSizeNow--;
            dataArray.remove(0);
            System.out.println("消费后数量:"+dateSizeNow);
            putCondition.signal();
        } catch (Exception e) {
            // todo
        } finally {
            reentrantLock.unlock();
        }

    }

}
