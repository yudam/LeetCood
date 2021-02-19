package com.design.list_struct;

import com.sun.net.httpserver.HttpsServer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * User: maodayu
 * Date: 2019/10/11
 * Time: 18:23
 */
public class Test {

    public static void main(String[] args) {

        Class clazz = HttpService.class;
        try {
            Method method = clazz.getDeclaredMethod("http",String.class,int.class);
            method.setAccessible(true);
            System.out.println(method);
            System.out.println(method.isDefault());
            System.out.println(method.getGenericReturnType());
            System.out.println(method.getDeclaringClass());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    interface HttpService {

        String http(String msg,int target);
    }
}
