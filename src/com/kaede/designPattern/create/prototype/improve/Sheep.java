package com.kaede.designPattern.create.prototype.improve;

/**
 * @author kaede
 * @create 2022-09-07 15:44
 */

public class Sheep implements Cloneable {
    private String name;
    private int age;
    private String color;
    private String type = "chinese";
    public Sheep friend;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", friend=" + friend +
                '}';
    }

    @Override
    protected Object clone(){
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sheep;
    }
}
