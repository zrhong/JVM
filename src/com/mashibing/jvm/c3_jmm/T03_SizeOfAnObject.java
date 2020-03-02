package com.mashibing.jvm.c3_jmm;

import com.zrhong.jvm.agent.ObjectSizeAgent;

public class T03_SizeOfAnObject {
    public static void main(String[] args) {
        System.out.println(ObjectSizeAgent.sizeOf(new Object()));
        System.out.println(ObjectSizeAgent.sizeOf(new int[] {}));
        System.out.println(ObjectSizeAgent.sizeOf(new P()));
    }

    //一个Object占多少个字节
    // -XX:+UseCompressedClassPointers -XX:+UseCompressedOops
    // Oops = ordinary object pointers
    private static class P {
                        //8 _markword             8
                        //4 _class pointer        8
        int id;         //4                       4
        String name;    //4                       8
        int age;        //4                       4

        byte b1;        //1                       1
        byte b2;        //1                       1

        Object o;       //4                       8
        byte b3;        //1                       1

    }
}
