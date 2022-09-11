package com.kaede.principle.dependenceInversion;

/**
 * @author kaede
 * @create 2022-09-03 22:37
 *
 * 依赖关系传递的三种方式：
 * 1、接口传递
 * 2、构造方法传递
 * 3、set方式传递
 */

public class DependenceInversion3 {
    public static void main(String[] args) {
        /*OpenAndClose openAndClose = new OpenAndClose;
        openAndClose.play(new LTC());*/
        /*OpenAndClose openAndClose = new OpenAndClose(new LTC());
        openAndClose.play();*/
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.setTV(new LTC());
        openAndClose.open();
    }
}

/*//方式1：通过接口传递依赖
//开关的接口
interface IOpenAndClose {
    void open(ITV tv);
}
//TV接口
interface ITV {
    void play();
}
//实现接口
class OpenAndClose implements IOpenAndClose {
    public void open(ITV tv) {
        tv.play();
    }
}*/

class LTC implements ITV {
    @Override
    public void play() {
        System.out.println("LTC open..");
    }
}

/*//方式2：通过构造方法传递依赖
//开关的接口
interface IOpenAndClose {
    void open();
}
//TV接口
interface ITV {
    void play();
}
//实现接口
class OpenAndClose implements IOpenAndClose {
    private ITV tv;
    public OpenAndClose(ITV tv) {
        this.tv = tv;
    }
    public void open() {
        this.tv.play();
    }
}*/

//方式3：通过set方法传递依赖
//开关的接口
interface IOpenAndClose {
    void open();
}
//TV接口
interface ITV {
    void play();
}
//实现接口
class OpenAndClose implements IOpenAndClose {
    private ITV tv;
    public void setTV(ITV tv) {
        this.tv = tv;
    }
    public void open() {
        this.tv.play();
    }
}
