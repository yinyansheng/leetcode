package com.donne.jvm;

public class JvmDemo {

    public static void main(String[] args) {
        JvmDemo jvmDemo = new JvmDemo();
        int a = 1;
        int b = 2;
        System.out.println(jvmDemo.add(a, b));
    }

    public int add(int i, int j) {
        return i + j;
    }
}
