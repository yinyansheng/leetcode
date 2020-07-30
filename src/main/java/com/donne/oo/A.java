package com.donne.oo;

public abstract class A {

    static {
        System.out.println("A 类对象创建");
    }

    {
        System.out.println("A 实例对象创建");
    }

    public A() {
        getNumber();
    }

    public abstract Integer getNumber();

}
