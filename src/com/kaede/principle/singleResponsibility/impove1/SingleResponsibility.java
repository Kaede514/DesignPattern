package com.kaede.principle.singleResponsibility.impove1;

/**
 * @author kaede
 * @create 2022-09-03 21:54
 */
public class SingleResponsibility {

    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("自行车");
        roadVehicle.run("汽车");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }

}

//方式2的分析：1、遵守单一职责原则
//           2、但是这样做的改动很大，即将类分解，同时修改客户端
//           3、改进：直接修改Vehicle类，改动的代码会比较少 -> 方式3
class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "公路运行");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "水中运行");
    }
}
class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "空中运行");
    }
}