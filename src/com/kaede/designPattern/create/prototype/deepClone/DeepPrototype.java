package com.kaede.designPattern.create.prototype.deepClone;

import java.io.*;

/**
 * @author kaede
 * @create 2022-09-07 16:24
 */

public class DeepPrototype implements Cloneable, Serializable {

    private String name;
    private DeepCloneableTarget deepCloneableTarget;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepCloneableTarget getDeepCloneableTarget() {
        return deepCloneableTarget;
    }

    public void setDeepCloneableTarget(DeepCloneableTarget deepCloneableTarget) {
        this.deepCloneableTarget = deepCloneableTarget;
    }

    //深拷贝-方式1：使用clone方法
    @Override
    protected Object clone() {
        Object deep = null;
        try {
            //完成对基本数据类型属性的克隆
            deep = super.clone();
            //对引用类型属性进行单独处理
            DeepPrototype deepPrototype = (DeepPrototype) deep;
            deepPrototype.setDeepCloneableTarget((DeepCloneableTarget) deepCloneableTarget.clone());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deep;
    }

    //深拷贝-方式2：通过对象的序列化实现深拷贝（推荐）
    public DeepPrototype deepClone() {
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepPrototype copy = (DeepPrototype) ois.readObject();
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
