package com.donne.designPattern.abstractFactory;

public class Main {
    public static void main(String[] args) {
        HumanFactory humanFactory = new FemaleHumanFactory();
        Human blackHuman = humanFactory.createBlackHuman();
        blackHuman.color();
        blackHuman.gender();
        blackHuman.say();

        HumanFactory humanFactory2 = new MaleHumanFactory();
        Human human2 = humanFactory2.createYellowHuman();
        human2.color();
        human2.gender();
        human2.say();
    }
}
