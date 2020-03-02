package com.mashibing.jvm.lock;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2020/2/10 23:21
 * @description 死锁使用jvm命令观察
 */
public class DeadLock {
    public final Object lock1 = new Object();
    public final Object lock2 = new Object();

    public void m(){
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + "m");
            n();
        }
    }

    public void n(){
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + "n");
            m();
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(() -> {
            deadLock.m();
        }).start();

        new Thread(() -> {
            deadLock.n();
        }).start();
    }
}
