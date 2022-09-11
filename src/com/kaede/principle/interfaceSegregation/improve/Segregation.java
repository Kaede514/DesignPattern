package com.kaede.principle.interfaceSegregation.improve;

/**
 * @author kaede
 * @create 2022-09-03 22:10
 *
 * 应传统方法的问题使用接口隔离原则进行改进：
 *     1）类A通过Interface1依赖类B，类C通过接口Interface1依赖类D，
 *        若接口Interface1对类A和类C来说不是最小接口，那么类B和类D
 *        必须实现它们不需要的方法
 *     2）将接口Interface1差分为独立的几个接口，类A和类Ｃ分别与它们
 *      　需要的接口建立依赖关系，即采用接口隔离原则
 *     3）接口Interface1中出现的方法根据实际情况拆分为3个接口
 */

public class Segregation {
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());
        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());
    }
}

interface Interface1 {
    void method1();
}

interface Interface2 {
    void method2();
    void method3();
}

interface Interface3 {
    void method4();
    void method5();
}

class B implements Interface1,Interface2 {
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
}

class D implements Interface1,Interface3 {
    @Override
    public void method1() {
        System.out.println("类D实现了method1");
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

class A {
    public void depend1(Interface1 i) {
        i.method1();
    }

    public void depend2(Interface2 i) {
        i.method2();
    }

    public void depend3(Interface2 i) {
        i.method3();
    }
}

class C {
    public void depend1(Interface1 i) {
        i.method1();
    }

    public void depend4(Interface3 i) {
        i.method4();
    }

    public void depend5(Interface3 i) {
        i.method5();
    }
}
