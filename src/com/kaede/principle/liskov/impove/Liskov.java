package com.kaede.principle.liskov.impove;

/**
 * @author kaede
 * @create 2022-09-04 12:03
 */

public class Liskov {
    public static void main(String[] args) {
        B b = new B();
        //因为B类不继承A类，因此调用者不会认为fun1是求剑法
        //调用完成的功能就会很明确
        System.out.println("11 + 3 = " + b.fun1(11, 3));
        System.out.println("11 + 3 + 9" + b.fun2(11, 3));
        //使用组合仍可以调用A的方法
        System.out.println("11 - 3 = "+ b.fun3(11, 3));
    }
}

//创建一个更加基础的基类，把更加基础的方法和成员写到Base类
class Base {

}

class A {
    //返回两个数的差
    public int fun1(int num1, int num2) {
        return num1 - num2;
    }
}

//B类继承了A类
//新增一个功能，完成两数相加，然后加9求和
class B extends Base{
    private A a = new A();

    public int fun1(int a, int b) {
        return a + b;
    }

    public int fun2(int a, int b) {
        return fun1(a, b) + 9;
    }

    //若想用A的方法
    public int fun3(int a, int b) {
        return this.a.fun1(a, b);
    }
}
