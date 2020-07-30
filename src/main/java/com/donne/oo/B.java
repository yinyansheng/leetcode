package com.donne.oo;

public class B extends A {

    static {
        System.out.println("B 类对象创建");
    }

    {
        System.out.println("B 实例对象创建");
    }


    @Override
    public Integer getNumber() {
        return 100;
    }

    public static void main(String[] args) {
        B a = new B();
    }
}
