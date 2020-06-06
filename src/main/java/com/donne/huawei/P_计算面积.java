package com.donne.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P_计算面积 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //指令数
        int n = scanner.nextInt();
        //横坐标 终点e
        int e = scanner.nextInt();

        List<Point> pointList = new ArrayList<>();
        int y = 0;
        int x = 0;
        for (int i = 0; i < n; i++) {
            x = scanner.nextInt();
            y += scanner.nextInt();
            Point point = new Point(x, y);
            pointList.add(point);
        }

        //corner case
        if (x != e) {
            pointList.add(new Point(e, y));
        }

        //compute area
        //area=(X2-X1)*abs(y1);
        int sumArea = 0;
        for (int i = 1; i < pointList.size(); i++) {
            int area = (pointList.get(i).getX() - pointList.get(i - 1).getX()) * Math.abs(pointList.get(i).getY());
            sumArea += area;
        }

        System.out.println(sumArea);
    }
}

class Point {
    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    private Integer x;
    private Integer y;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
