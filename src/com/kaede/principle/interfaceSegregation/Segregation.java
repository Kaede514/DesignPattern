package com.kaede.principle.interfaceSegregation;

/**
 * @author kaede
 * @create 2022-09-03 22:10
 *
 * 接口隔离原则：客户端不应该依赖它不需要的接口，即一个类
 *             对另一个类的依赖应该建立在最小的接口上
 */

public class Segregation {
    public static void main(String[] args) {

    }
}

interface Interface1 {
    void method1();
    void method2();
    void method3();
    void method4();
    void method5();
}

class B implements Interface1 {
    @Override
    public void method1() {
        System.out.println("类B实现了method1");
    }

    @Override
    public void method2() {
        System.out.println("类B实现了method2");
    }

    @Override
    public void method3() {
        System.out.println("类B实现了method3");
    }

    @Override
    public void method4() {
        System.out.println("类B实现了method4");
    }

    @Override
    public void method5() {
        System.out.println("类B实现了method5");
    }
}

class D implements Interface1 {
    @Override
    public void method1() {
        System.out.println("类D实现了method1");
    }

    @Override
    public void method2() {
        System.out.println("类D实现了method2");
    }

    @Override
    public void method3() {
        System.out.println("类D实现了method3");
    }

    @Override
    public void method4() {
        System.out.println("类D实现了method4");
    }

    @Override
    public void method5() {
        System.out.println("类D实现了method5");
    }
}

//A类通过接口Interface1使用B类，但是只会用到method1、method2、method3
class A {
    public void depend1(Interface1 i) {
         i.method1();
    }

    public void depend2(Interface1 i) {
         i.method2();
    }

    public void depend3(Interface1 i) {
         i.method3();
    }
}

//C类通过接口Interface1使用D类，但是只会用到method1、method4、method5
class C {
    public void depend1(Interface1 i) {
         i.method1();
    }

    public void depend4(Interface1 i) {
         i.method4();
    }

    public void depend5(Interface1 i) {
         i.method5();
    }
}
