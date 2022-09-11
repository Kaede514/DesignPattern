package com.kaede.principle.dependenceInversion;

/**
 * @author kaede
 * @create 2022-09-03 22:37
 *
 * 依赖倒转原则：
 *     1）高层模块不应该依赖底层模块，二者都应该依赖其抽象
 *     2）抽象不应该依赖细节，细节应该依赖抽象
 *     3）依赖倒转（倒置）的中心思想是面向接口编程
 *     4）依赖倒转原则是基于这样的设计理念：相对于细节的多变性，抽象要
 *        稳定的多。以抽象为基础搭建的架构比以细节为基础搭建的架构要稳
 *        定的多，在java中，抽象指的是接口或抽象类，细节就是具体的实现类
 *     5）使用接口或抽象类的目的是制定好规范，而不涉及任何具体的操作，把
 *        展示细节的任务交给他们的实现类去完成
 *
 * 依赖倒转原则注意事项和细节：
 *     1）底层模块尽量都要有抽象类或接口，或者两者都有，程序稳定性更好
 *     2）变量的声明类型尽量是抽象类或接口，这样变量引用和实际对象间就存在
 *        一个缓冲层，有利于程序扩展和优化
 *     3）继承时遵守里氏替换原则
 */

public class DependenceInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email {
    public String getInfo() {
        return "email...";
    }
}

//完成Person接收消息的目的
//方式1分析：1、简单，比较容易想到
//         2、若需要获取短信、微信等，则需新增类，同时Person也要增加相应的接收
//解决思路：引入一个抽象的接口Receiver，表示接收者，让Person类与接口发生依赖
//        （由于Email、WeiXin等属于接收的范围，只要各自实现Receiver接口即可，这样就符合依赖倒转原则）
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
