package com.mashibing.jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2020/2/11 22:39
 * @description 测试常量池在不同版本的位置  jdk1.6 -XX:PermSize=6M ,-XX:MMaxPermSize=6m
 */
public class RunTimeConstantPoolOOM {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String s = stringBuilder.append("计算机").append("软件").toString();
        System.out.println(s.intern()==s);
    }
}
