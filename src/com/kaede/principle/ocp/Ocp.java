package com.kaede.principle.ocp;

/**
 * @author kaede
 * @create 2022-09-04 12:29
 *
 * 开闭原则：
 *     1）一个软件实体如类、模块和函数应该对拓展开发（对提供方），
 *        对修改关闭（对使用方），用抽象构建框架，用实现拓展细节
 *     2）当软件需要变化时，尽量通过拓展软件实体的行为来实现变化，
 *        而不是通过修改已有的代码来实现变化
 *     3）编程中遵循其他原则，以及使用设计模式的目的就是遵守开闭原则
 *
 * 方式1的优缺点：
 *     1）优点是比较好理解，操作简单
 *     2）缺点是违反设计模式的ocp原则，即当给类新增加功能时，尽量不修改
 *        代码，或者尽可能少修改代码
 *     3）比如这是如果要新增一个图形类，修改的地方会比较多
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
        if(s.type == 1) {
            drawRectangle(s);
        } else if(s.type == 2) {
            drawCircle(s);
        } else if(s.type == 3) {
            drawTriangle(s);
        }
    }

    public void drawRectangle(Shape s) {
        System.out.println("矩形");
    }

    public void drawCircle(Shape s) {
        System.out.println("圆形");
    }

    public void drawTriangle(Shape s) {
        System.out.println("三角形");
    }
}

class Shape {
    int type;
}

class Rectangle extends Shape {
    public Rectangle() {
        super.type = 1;
    }
}

class Circle extends Shape {
    public Circle() {
        super.type = 2;
    }
}

//新增一个三角形类
class Triangle extends Shape {
    public Triangle() {
        super.type = 3;
    }
}