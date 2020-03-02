package com.mashibing.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.Random;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2020/2/28 14:17
 * @description
 */
public class MethodHandleTest {

    int x = 9;
    static class ClassA{
        public void println(String s) {
            System.out.println(s);
        }
    }

    class LogProxy {
        public void proxyMethod(Object proxy,
                                String methodName,
                                Class returnType,
                                Object... args
                                ){

        }
    }
    public static void main(String[] args) throws Throwable {
        Object o =/* new Random().nextBoolean() ? System.out : */new ClassA();
        getPrintlnMH(o).invokeExact("12133");
    }

    private static MethodHandle getPrintlnMH(Object reveiver) throws NoSuchMethodException, IllegalAccessException {
        MethodType mt = MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);
    }

}
