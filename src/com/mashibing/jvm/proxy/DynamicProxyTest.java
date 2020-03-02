package com.mashibing.jvm.proxy;

import com.mashibing.jvm.c0_basic.T;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2020/2/28 15:58
 * @description
 */
public class DynamicProxyTest {

    interface SaveHello{
        void saveHello();
    }

   static class SaveHelloImpl implements SaveHello {
        @Override
        public void saveHello() {
            System.out.println("save");
        }
    }

    static class ProxyClass implements InvocationHandler{

        private Object orginal;

        Object bind(Object orginal) {
            this.orginal = orginal;
            return Proxy.newProxyInstance(orginal.getClass().getClassLoader(), orginal.getClass().getInterfaces(), this);
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("log");
            return method.invoke(orginal, args);
        }
    }

    public static void main(String[] args) {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        SaveHello hello = (SaveHello) new ProxyClass().bind((new SaveHelloImpl()));
        hello.saveHello();
    }

}
