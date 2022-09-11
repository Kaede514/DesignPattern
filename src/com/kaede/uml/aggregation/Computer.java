package com.kaede.uml.aggregation;

/**
 * @author kaede
 * @create 2022-09-06 19:48
 */

public class Computer {
    private Mouse mouse;    //Mouse可以和Computer分离
    private Monitor monitor;    //Monitor可以和Computer分离

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}
