package com.kaede.principle.dependenceInversion;

/**
 * @author kaede
 * @create 2022-09-03 22:37
 */

public class DependenceInversion2 {
    public static void main(String[] args) {
        Person2 person = new Person2();
        person.receive(new Email2());
        person.receive(new WeiXin());
    }
}

interface Receiver {
    String getInfo();
}

class Email2 implements Receiver {
    public String getInfo() {
        return "email...";
    }
}

class WeiXin implements Receiver {
    public String getInfo() {
        return "weixin...";
    }
}

class Person2 {
    //这里是对接口的依赖
    public void receive(Receiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
