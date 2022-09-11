package com.kaede.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kaede
 * @create 2022-09-04 12:50
 *
 * 迪米特法则：
 *     1）一个对象应该对其他对象保持最小的了解
 *     2）类与类关系越密切，耦合度越大
 *     3）迪米特法则又叫最小知道原则，即一个类对自己依赖的类知道的越少
 *        越好。对于被依赖的类不管多复杂，都尽量将逻辑封装在类的内部，
 *        对外除了提供public方法外，不泄露任何信息
 *     4）迪米特法则还有个简单的定义：只与直接的朋友通信
 *     5）直接的朋友：每个对象都与其他对象有耦合关系，只要两个对象之间
 *        有耦合关系，就称这两个对象间是朋友关系。耦合的方式有很多，如
 *        依赖、关联、组合、聚合等，其中，称出现成员变量、方法参数和方法
 *        返回值中的类为直接的朋友，而出现在局部变量中的类不是直接的朋友，
 *        即陌生的类最好不要以局部变量的形式出现在类的内部
 *
 * 迪米特法则注意事项和细节：
 *     1）迪米特法则的核心是降低类之间的耦合
 *     2）但注意：由于每个类都减少了不必要的依赖，因此迪米特法则只是要求降低
 *        类间（对象间）的耦合关系，并不是要求完全没有依赖关系
 *
 */

public class Demeter {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        //输出学院的员工id和学校总部的员工id
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

class CollegeEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class CollegeManager {
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee collegeEmployee = new CollegeEmployee();
            collegeEmployee.setId("id: " + i);
            list.add(collegeEmployee);
        }
        return list;
    }

    public void printEmployee() {
        List<CollegeEmployee> list1 = this.getAllEmployee();
        System.out.println("===================");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
    }
}

class SchoolEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class SchoolManager {
    public List<SchoolEmployee> getAllEmployee() {
        List<SchoolEmployee> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
           SchoolEmployee emp = new SchoolEmployee();
            emp.setId("id: " + i);
            list.add(emp);
        }
        return list;
    }

    public void printAllEmployee(CollegeManager cm) {
        cm.printEmployee();
        List<SchoolEmployee> list2 = this.getAllEmployee();
        System.out.println("===================");
        for (SchoolEmployee e : list2) {
            System.out.println(e.getId());
        }
    }
}
