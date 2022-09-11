package com.kaede.designPattern.create.singleton.type1;

/**
 * @author kaede
 * @create 2022-09-06 20:50
 *
 * 单例模式：采取一定方法保证在整个的软件系统中，对某个类只能存在一个
 *          实例对象，并且该类只提供一个取得其对象实例的方法
 *
 * 单例模式有八种方式：
 *     1）饿汉式（静态常量）（看情况）
 *     2）饿汉式（静态代码块）（看情况）
 *     3）懒汉式（线程不安全）
 *     4）懒汉式（线程安全，同步方法）
 *     5）懒汉式（线程安全，同步代码块）
 *     6）双重检查（推荐）
 *     7）静态内部类（推荐）
 *     8）枚举（推荐）
 *
 * 饿汉式（静态常量）步骤：
 *     1）构造器私有化（防止外部new）
 *     2）类的内部创建对象
 *     3）向外暴露一个静态的公共方法（getInstance）
 *     4）代码实现
 *
 * 优缺点说明
 *     1）优点：在类装载时就完成了实例化，避免了线程同步问题
 *     2）缺点：在类装载时就完成了实例化，没有达到Lazy Loading的效果，如果从
 *             始至终从未使用过这个实例，则会造成内存的浪费
 *     3）这种方式基于classloader机制避免了多线程的同步问题，不过instance在
 *        类装载时就实例化，在单例模式中大多数都是调用getInstance()方法，但是
 *        导致类装载的原因有很多种，因此不能确定有其他方式导致类装载，这时候初始
 *        化instance就没有达到Lazy Loading的效果
 *     4）结论：这种单例模式可用，可能会造成内存浪费
 *
 * 单例模式注意事项和细节说明：
 *     1）单例模式保证了系统内存中该类只存在一个对象，节省了系统资源，对于一些需要
 *        频繁创建销毁的对象，使用单例模式可以提高系统性能
 *     2）当想实例化一个单例类时，要记住使用相应的获取对象的方法，而不是使用new
 *     3）单例模式的使用场景：需要频繁创建销毁、创建耗时过长或耗费资源过多，但又经常
 *        用到的对象，如工具类对象、频繁访问数据库或文件的对象（数据源、session工厂等）
 *
 */

public class SingletonTest1 {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }

}

class Singleton {

    private final static Singleton INSTANCE = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

}










