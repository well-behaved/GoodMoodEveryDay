package com.xue.demo.algorithm.demo;

public class 三个线程交替打印synchronized版 {
    public static void main(String[] args) {
        Object localObject = new Object();
        MyNum num = new MyNum(0);
        MyThreadDemo threadOne = new MyThreadDemo(localObject, num, "线程1", 1);
        MyThreadDemo threadTwo = new MyThreadDemo(localObject, num, "线程2", 2);
        MyThreadDemo threadThree = new MyThreadDemo(localObject, num, "线程3", 3);
        new Thread(threadOne).start();
        new Thread(threadTwo).start();
        new Thread(threadThree).start();

    }
}

class MyNumDemo {
    private Integer num;

    public MyNumDemo(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}

class MyThreadDemo implements Runnable {
    //锁对象
    private final Object lockObject;
    private MyNum num;
    //本线程应该打印的数
    private Integer myNum;
    //线程名称
    private final String name;

    MyThreadDemo(Object lockObject, MyNum num, String name, Integer myNum) {
        this.lockObject = lockObject;
        this.num = num;
        this.name = name;
        this.myNum = myNum;
    }

    @Override
    public void run() {
        while (true) {
            if(num.getNum() > 100){
                break;
            }
            if (num.getNum() % 3 + 1 == myNum) {
                synchronized (lockObject) {
                    //防止线程冲突在判断一次
                    if (num.getNum() > 100) {
                        break;
                    }
                    if (num.getNum() % 3 + 1 != myNum) {
                        notifyAll();
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }


                    System.out.println(name + "打印" + num.getNum());
                    num.setNum(num.getNum() + 1);
                    //唤醒其他线程
                    lockObject.notifyAll();
                    try {
                        if (num.getNum() > 100) {
                            break;
                        }
                        //自己等待
                        lockObject.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

