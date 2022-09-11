package com.kaede.designPattern.create.prototype.deepClone;

import java.io.Serializable;

/**
 * @author kaede
 * @create 2022-09-07 16:22
 */

public class DeepCloneableTarget implements Cloneable, Serializable {

    private String cloneName;
    private String cloneClass;

    @Override
    public String toString() {
        return "DeepCloneableTarget{" +
                "cloneName='" + cloneName + '\'' +
                ", cloneClass='" + cloneClass + '\'' +
                '}';
    }

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
