package com.kaede.principle.liskov;

/**
 * @author kaede
 * @create 2022-09-04 12:03
 *
 * 里氏替换原则：
 *     1）如果对每个类型为T1的对象o1，都有类型为T2的对象o2，
 *        使得以T1定义的所有程序P在所有的对象o1都代换成o2时，
 *        程序P的行为没有发生变化，那么类型T1是类型T1的子类型，
 *        即所有引用基类的地方必须能透明的使用其子类的对象
 *     2）在使用继承时，遵循里氏原则，在子类中尽量不要重写父类的方法
 *     3）继承让两个类的耦合增强了，在适当的情况下，可以通过聚合、组
 *        合、依赖来解决问题
 *
 * 解决方法：
 *     1）发现原来运行正常的相减功能发生了错误，原因是类B无意中重写了父类
 *        的方法，造成原有功能异常，在实际编程中，常常会通过重写父类的方法
 *        完成新的功能，这样虽然写起来简单，但整个继承体系的复用性会比较差，
 *        特别是多态比较频繁的时候
 *     2）通用做法是：原来的父类和子类都继承一个更通俗的基类，原有的继承关系
 *        去掉，采用依赖、聚合、组合等关系代替
 */

public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11 - 3 = " + a.fun1(11, 3));
        B b = new B();
        //本意是求11 - 3，但不小心重写了方法
        System.out.println("11 - 3 = "+ b.fun1(11, 3));
        System.out.println("11 + 3 + 9"+ b.fun2(11, 3));
    }
}

class A {
    //返回两个数的差
    public int fun1(int num1, int num2) {
        return num1 - num2;
    }
}

//B类继承了A类
//新增一个功能，完成两数相加，然后加9求和
class B extends A{
    public int fun1(int a, int b) {
        return a + b;
    }

    public int fun2(int a, int b) {
        return fun1(a, b) + 9;
    }
}
