package com.kaede.designPattern.create.singleton.type8;

/**
 * @author kaede
 * @create 2022-09-07 12:17
 * 
 * 枚举
 * 
 * 优缺点说明：
 *     1）借助JDK1.5中添加的枚举来实现单例模式，不仅能避免多线程同步问题，而且
 *        还能防止反序列化重新创建新的对象
 *     2）结论：推荐使用
 * 
 */

public class SingletonTest8 {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance1 == instance2);
        instance1.sayHello();
    }

}

enum Singleton {
    INSTANCE;

    public void sayHello() {
        System.out.println("hello...");
    }
}
