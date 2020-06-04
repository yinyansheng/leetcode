package com.donne.designPattern;


/**
 * DCL
 */
public class SingletonHolder2 {

    private volatile Object object;

    public Object getInstance() {
        if (null == object) {
            synchronized (Object.class) {
                if (null == object) {
                    object = new Object();
                }
            }
        }
        return object;
    }
}
