package com.donne.common.temp;

import org.openjdk.jol.info.ClassLayout;

public class JOLDemo {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        int[] arr = new int[11];
        arr[1]=100;
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());
    }
}
