package com.donne.common.temp;

public class FunctionInterfaceDemo {

    public static void main(String[] args) {
        System.out.println(add(1, 2, (a, b) -> a + a + b + b));
    }

    private static int add(int a, int b, AddProvider addProvider) {
        int add = addProvider.add(a, b);
        return add;
    }
}
