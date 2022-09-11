package com.kaede.designPattern.create.singleton.type5;

/**
 * @author kaede
 * @create 2022-09-06 21:28
 *
 * 懒汉式（线程安全，同步代码块）
 *
 * 优缺点说明：
 *     1）这种方式的本意是想改进第四种实现方式，因为前面同步方法效率太低，
 *        改为同步产生实例化的代码块，但这种同步方式并不能起到线程同步的
 *        作用，如果一个线程进入了if(instance == null)判断语句块，还未
 *        来得及往下执行，另一个线程也进入了if(instance == null)判断语
 *        句块，这时就会产生多个实例
 *     2）结论：在实际开发中，不要使用这种方式
 *
 */

public class SingletonTest5 {

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
                instance = new Singleton();
            }
        }
        return instance;
    }

}