package com.kaede.designPattern.create.singleton.type2;

/**
 * @author kaede
 * @create 2022-09-06 21:10
 *
 * 饿汉式（静态代码块）
 *
 * 优缺点说明：
 *     1）和饿汉式（静态常量）的方式类似，只不过将实例化的过程放在了静态代码块中，
 *        也就是在类装载的时候执行静态代码块，初始化类的实例优缺点和上面一样
 *     2）结论：这种单例模式可用，可能会造成内存浪费
 *
 */

public class SingletonTest2 {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }

}

class Singleton {

    private final static Singleton INSTANCE;

    static {
        INSTANCE = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

}
