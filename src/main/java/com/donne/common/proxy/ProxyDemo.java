package com.donne.common.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        Star ldh = new LiuDeHua();
        JdkProxy jdkProxy = new JdkProxy();
        jdkProxy.setTarget(ldh);
        Star ldhProxy = (Star) jdkProxy.createProxy();

        ldhProxy.sing("hhh");
        ldhProxy.dance("ggg");

        Hello hello = new HelloImpl();
        jdkProxy.setTarget(hello);
        Hello helloProxy = (Hello) jdkProxy.createProxy();
        String donne = helloProxy.Say("donne");
        System.out.println(donne);


        CglibProxy cglibProxy = new CglibProxy();
        Hello helloProxy1 = (Hello) cglibProxy.createProxy(HelloImpl.class);
        System.out.println(helloProxy1.Say("kkkkk"));
    }
}
