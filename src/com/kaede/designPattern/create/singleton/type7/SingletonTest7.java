package com.kaede.designPattern.create.singleton.type7;

/**
 * @author kaede
 * @create 2022-09-07 12:06
 *
 * 静态内部类
 *
 * 优缺点说明：
 *     1）采用了类装载机制保证初始化实例时只有一个线程
 *     2）静态内部类方式在Singleton类被装载时不会立即实例化，而是在需要
 *        实例化时调用getInstance()方法，才会装载SingletonInstance类，
 *        从而完成Singleton实例化
 *     3）类的静态属性只会在第一次加载类的时候初始化，JVM保证了线程的安全
 *        性，在类进行初始化时，别的线程无法进入
 *     4）避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
 *     5）结论：推荐使用
 *
 */

public class SingletonTest7 {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }

}

class Singleton {

    private Singleton() {

    }

    private static class SingletonInstance {
        private final static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

}