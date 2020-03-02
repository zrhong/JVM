package com.mashibing.jvm.c3_jmm;

public class LazySingleton {
 
    private static volatile LazySingleton instance = null;
     
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
         
        return instance;
    }
     
    public static void main(String[] args) {
        LazySingleton.getInstance();
    }

}