package com.kaede.designPattern.create.singleton.type3;

/**
 * @author kaede
 * @create 2022-09-06 21:15
 *
 * 懒汉式（线程不安全）
 *
 * 优缺点说明：
 *     1）起到了Lazy Loading的效果，但是只能在单线程下使用
 *     2）如果在单线程下，一个线程进入了if(instance == null)判断语句块，还未来得及
 *        往下执行，另一个线程也进入了if(instance == null)判断语句块，就会导致产生
 *        多个实例，所以在多线程环境下不可使用这种方式
 *     3）结论：在实际开发中，不要使用这种方式
 *
 */

public class SingletonTest3 {

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
            instance = new Singleton();
        }
        return instance;
    }

}

