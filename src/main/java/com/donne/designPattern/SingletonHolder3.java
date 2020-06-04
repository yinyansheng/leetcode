package com.donne.designPattern;


/**
 * enum
 */
public enum SingletonHolder3 {

    color;

    private Object obj;

    private SingletonHolder3() {
        this.obj = new Object();
    }

    public Object getObject() {
        return obj;
    }
}


