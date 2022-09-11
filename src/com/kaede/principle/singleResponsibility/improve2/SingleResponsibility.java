package com.kaede.principle.singleResponsibility.improve2;

/**
 * @author kaede
 * @create 2022-09-03 21:54
 */
public class SingleResponsibility {

    public static void main(String[] args) {
        Vehicle2 vehicle = new Vehicle2();
        vehicle.runRoad("自行车");
        vehicle.runRoad("汽车");
        vehicle.runAir("飞机");
    }

}

//方式3的分析：1、这样修改方法没有对原来的类做大的修改，只是增加方法
//           2、这里没有在类级别上遵守单一职责原则，但在方法上遵守了单一职责原则
class Vehicle2 {
    public void runRoad(String vehicle) {
        System.out.println(vehicle + "公路运行");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + "水中运行");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + "空中运行");
    }
}
