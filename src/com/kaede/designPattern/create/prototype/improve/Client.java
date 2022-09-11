package com.kaede.designPattern.create.prototype.improve;

/**
 * @author kaede
 * @create 2022-09-07 15:45
 */

public class Client {

    public static void main(String[] args) {
        //传统的方式
        Sheep sheep = new Sheep("tom", 1, "white");
        sheep.friend = new Sheep("jack", 2, "black");
        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep1.friend.hashCode());
        System.out.println(sheep2.friend.hashCode());
        System.out.println(sheep3.friend.hashCode());
    }

}
