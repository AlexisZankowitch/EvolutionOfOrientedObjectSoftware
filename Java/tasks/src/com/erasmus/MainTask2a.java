package com.erasmus;

import com.erasmus.task2.EmployeeComparable;
import com.erasmus.task2.FirmComparator;

public class MainTask2a {
    public static void main(String[] args) {
        //Employee creation
        System.out.println('\n'+"Employee");
        EmployeeComparable e1 = new EmployeeComparable("Uldis","Petrov",1000.0);
        EmployeeComparable e2 = new EmployeeComparable("Ivars","Stradz",1400.0);
        EmployeeComparable e3 = new EmployeeComparable("Aldis","Zemzars",1200.0);
        System.out.println(e1);

        //Firm creation
        System.out.println('\n'+"Firm");
        FirmComparator f1 = new FirmComparator("VEF",30);
        //Add employee to firm
        f1.addEmployee(e1);
        f1.addEmployee(e2);
        f1.addEmployee(e3);
        System.out.println(f1);

        //Max salary
        System.out.println("Maximal salary: "+f1.getMaxSalary()+'\n');

        //SortingEmployees
        System.out.println("Ascending: ");
        f1.sortSalariesAsc();
        System.out.println(f1);
        System.out.println("Descending: ");
        f1.sortSalariesDesc();
        System.out.println(f1);


        //Exception handling
        System.out.println("Exception handling");
        f1.addEmployee(e1);
    }
}
