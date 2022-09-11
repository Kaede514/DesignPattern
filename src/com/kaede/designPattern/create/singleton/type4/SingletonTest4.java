package com.kaede.designPattern.create.singleton.type4;

/**
 * @author kaede
 * @create 2022-09-06 21:23
 *
 * 懒汉式（线程安全，同步方法）
 *
 * 优缺点说明：
 *     1）解决了线程不安全问题
 *     2）效率太低，每个线程在想获得类的实例时，执行getInstance()方法都要进行
 *        同步，而其实该方法只执行一次实例化代码就够了，后面的线程想获得该类实例
 *        的话，直接return就行了，方法进行同步效率太低
 *     3）结论：在实际开发中，不推荐使用这种方式
 *
 */

public class SingletonTest4 {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }

}

class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
