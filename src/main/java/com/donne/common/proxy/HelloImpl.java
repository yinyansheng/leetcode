package com.donne.common.proxy;

public class HelloImpl implements Hello {
    @Override
    public String Say(String name) {
        return "hello " + name;
    }
}
