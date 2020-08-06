package com.donne.designPattern.abstractFactory;

public abstract class Human {
    public void say() {
        System.out.println("我是人");
    }

    abstract void gender();

    abstract void color();
}
