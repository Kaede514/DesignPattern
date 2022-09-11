package com.kaede.principle.ocp.improve;

/**
 * @author kaede
 * @create 2022-09-04 12:29
 *
 * 改进的思路：创建抽象类Shape，提供一个抽象的draw方法，让子类去实现
 *            即可，若有新图形的话，只要让新图形继承Shape并实现draw
 *            方法即可，使用方的代码不需要修改，满足了开闭原则
 */

public class Ocp {
    public static void main(String[] args) {
        GraphEditor graphEditor = new GraphEditor();
        graphEditor.drawShape(new Rectangle());
        graphEditor.drawShape(new Circle());
        graphEditor.drawShape(new Triangle());
    }
}

class GraphEditor {
    public void drawShape(Shape s) {
        s.draw();
    }
}

abstract class Shape {
    abstract void draw();
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("矩形");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("圆形");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("三角形");
    }
}