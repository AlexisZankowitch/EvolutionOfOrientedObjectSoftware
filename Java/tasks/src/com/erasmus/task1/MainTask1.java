package com.erasmus.task1;

import com.erasmus.task1.Employee;
import com.erasmus.task1.Firm;

public class MainTask1 {

    public static void main(String[] args) {
        //Employee creation
        System.out.println('\n'+"Employee");
        Employee e1 = new Employee("Uldis","Petrov",1000.0);
        Employee e2 = new Employee("Aldis","Zemzars",1200.0);
        System.out.println(e1);

        //Firm creation
        System.out.println('\n'+"Firm");
        Firm f1 = new Firm("VEF",2);
        //Add employee to firm
        f1.addEmployee(e1);
        f1.addEmployee(e2);
        System.out.println(f1);
        //Exception handling
        System.out.println("Exception handling");
        f1.addEmployee(e1);
    }
}
