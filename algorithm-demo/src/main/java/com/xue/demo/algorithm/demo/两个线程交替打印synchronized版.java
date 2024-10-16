package com.xue.demo.algorithm.demo;

public class 两个线程交替打印synchronized版 {

    public static void main(String[] args) {
        Object localObject = new Object();
        MyNum num = new MyNum(0);
        MyThread threadOne =  new MyThread(localObject,num,"线程1");
        MyThread threadTwo = new MyThread(localObject,num,"线程2");
        new Thread(threadOne).start();
        new Thread(threadTwo).start();

    }
}
class MyNum{
    private Integer num;
    public MyNum(Integer num){
        this.num = num;
    }
    public Integer getNum(){
        return num;
    }
    public void setNum(Integer num){
        this.num = num;
    }
}
class MyThread implements Runnable{
    //锁对象
    private final Object  lockObject;
    private  MyNum num;
    //线程名称
    private final String name;
    MyThread(Object lockObject,MyNum num, String name) {
        this.lockObject = lockObject;
        this.num = num;
        this.name = name;
    }
    @Override
    public void run() {
        while(num.getNum() <=100){
            synchronized (lockObject){
                System.out.println(name+"打印"+num.getNum());
                num.setNum(num.getNum()+1);
                //唤醒其他线程
                lockObject.notify();
                try {
                    //自己等待
                    lockObject.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
