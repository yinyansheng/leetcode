package com.donne.jvm;

import java.math.BigDecimal;

public class JvmDemo {

    public static void main(String[] args) {
        T t=new T();

        JvmDemo jvmDemo = new JvmDemo();
        int a = 1;
        int b = 2;
        System.out.println(jvmDemo.add(a, b));

        BigDecimal bigDecimal = new BigDecimal(1.01);
    }

    public int add(int i, int j) {
        synchronized (this) {
            return i + j;
        }
    }
}
