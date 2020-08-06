package com.donne.designPattern.abstractFactory;

public class Main {
    public static void main(String[] args) {
        HumanFactory humanFactory = new FemaleHumanFactory();
        Human blackHuman = humanFactory.createBlackHuman();
        blackHuman.color();
        blackHuman.gender();
        blackHuman.say();
    }
}
