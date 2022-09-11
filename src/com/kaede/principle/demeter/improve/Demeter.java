package com.kaede.principle.demeter.improve;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kaede
 * @create 2022-09-04 12:50
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
        List<CollegeEmployee> list1 = cm.getAllEmployee();
        System.out.println("===================");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
        List<SchoolEmployee> list2 = this.getAllEmployee();
        System.out.println("===================");
        for (SchoolEmployee e : list2) {
            System.out.println(e.getId());
        }
    }
}
