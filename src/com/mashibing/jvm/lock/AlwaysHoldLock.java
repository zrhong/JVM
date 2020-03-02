package com.mashibing.jvm.lock;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2020/2/10 23:30
 * @description
 */
public class AlwaysHoldLock {
    public static synchronized void m(){
        while (true) {

        }
    }
    public static void main(String[] args) {
        for (int i = 0; i <1000 ; i++) {
            new Thread(() -> {
                m();
            }).start();
        }
    }
}
