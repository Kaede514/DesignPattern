package com.kaede.designPattern.create.prototype;

/**
 * @author kaede
 * @create 2022-09-07 15:45
 */

public class Client {

    public static void main(String[] args) {
        //传统的方式
        Sheep sheep = new Sheep("tom", 1, "white");
        Sheep sheep1 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep2 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep3 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
    }

}
