package com.kaede.designPattern.create.singleton.type6;

/**
 * @author kaede
 * @create 2022-09-06 21:34
 * 
 * 双重检查
 *
 * 优缺点说明：
 *     1）Double-Check概念时多线程开发中常用到的，如代码所示，进行了两次
 *        if(instance == null)检查，第二次检查时同步的，这样可样确保线
 *        程安全
 *     2）实例化代码只需执行一次，后面再次访问时，判断if(instance == null)
 *        直接return实例对象，也可用避免反复进行方法同步
 *     3）线程安全，延迟加载，效率较高
 *     4）结论：在实际开发中，推荐使用这种单例设计模式
 *
 */

public class SingletonTest6 {

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

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized(Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}