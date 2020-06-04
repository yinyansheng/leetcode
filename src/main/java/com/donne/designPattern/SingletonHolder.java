package com.donne.designPattern;


/**
 * 懒汉式
 */
public class SingletonHolder {

    private final static Object object = new Object();

    public Object getInstance() {
        return object;
    }
}
