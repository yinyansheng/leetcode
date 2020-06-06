package com.donne.huawei;

import java.util.*;

public class P_九宫格按键 {

    public static void main(String[] args) {
        Keyboard keyboard = new Keyboard();
        Scanner scanner = new Scanner(System.in);


        String line = scanner.nextLine();
        for (char key : line.toCharArray()) {
            switch (key) {
                case '#':
                    keyboard.pressSharp();
                    break;
                case '/':
                    keyboard.pressSlash();
                    break;
                default:
                    keyboard.pressNumber(key);
            }
        }

        keyboard.pressSlash();
        System.out.println();
    }

}


class Keyboard {
    //当前模式 0：数字模式 1:字母模式
    int mode = 0;

    //当前按键
    Character currentKey;

    //当前按键索引值
    int currentKeyIndex = 0;

    private Map<Character, List<Character>> keyContext = new HashMap<>();

    {
        keyContext.put('1', Arrays.asList(',', '.'));
        keyContext.put('2', Arrays.asList('a', 'b', 'c'));
        keyContext.put('3', Arrays.asList('d', 'e', 'f'));
        keyContext.put('4', Arrays.asList('g', 'h', 'i'));
        keyContext.put('5', Arrays.asList('j', 'k', 'l'));
        keyContext.put('6', Arrays.asList('m', 'n', 'o'));
        keyContext.put('7', Arrays.asList('p', 'q', 'r', 's'));
        keyContext.put('8', Arrays.asList('t', 'u', 'v'));
        keyContext.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        keyContext.put('0', Collections.singletonList(' '));
    }

    public void pressSharp() {
        this.mode = (this.mode + 1) % 2;
        currentKeyIndex = 0;
    }

    private boolean isDigitalMode() {
        return this.mode == 0;
    }

    public void pressSlash() {
        //如果是数字模式 不做处理
        if (isDigitalMode() || null == currentKey) {
            return;
        }

        System.out.print(keyContext.get(currentKey).get(currentKeyIndex));
        currentKey = null;
        currentKeyIndex = 0;
    }

    public void pressNumber(Character key) {
        //如果是数字模式 直接输出
        if (isDigitalMode()) {
            System.out.print(key);
            return;
        }

        //如果是英文模式
        if (null == currentKey) {
            currentKey = key;
            currentKeyIndex = 0;
            return;
        }

        if (!key.equals(currentKey)) {
            System.out.print(keyContext.get(currentKey).get(currentKeyIndex));
            currentKey = key;
            currentKeyIndex = 0;
            return;
        }

        currentKeyIndex = (currentKeyIndex + 1) % keyContext.get(currentKey).size();
    }
}
