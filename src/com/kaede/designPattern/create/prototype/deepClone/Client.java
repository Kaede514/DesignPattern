package com.kaede.designPattern.create.prototype.deepClone;

/**
 * @author kaede
 * @create 2022-09-07 16:29
 */

public class Client {

    public static void main(String[] args) {
        DeepPrototype deepPrototype = new DeepPrototype();
        deepPrototype.setName("deepPrototype");
        deepPrototype.setDeepCloneableTarget(new DeepCloneableTarget("name", "class"));
        //方式1完成深拷贝
        DeepPrototype deepPrototype1 = (DeepPrototype) deepPrototype.clone();
        DeepPrototype deepPrototype2 = (DeepPrototype) deepPrototype.clone();
        System.out.println(deepPrototype1);
        System.out.println(deepPrototype2);
        System.out.println(deepPrototype1.hashCode());
        System.out.println(deepPrototype2.hashCode());

        //方式2完成深拷贝
        DeepPrototype deepPrototype3 = deepPrototype.deepClone();
        DeepPrototype deepPrototype4 = deepPrototype.deepClone();
        System.out.println(deepPrototype3);
        System.out.println(deepPrototype4);
        System.out.println(deepPrototype3.hashCode());
        System.out.println(deepPrototype4.hashCode());
    }

}
