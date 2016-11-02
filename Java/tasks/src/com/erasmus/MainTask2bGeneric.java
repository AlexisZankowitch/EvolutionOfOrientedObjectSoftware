package com.erasmus;


import com.erasmus.task2.EmployeeGenericComparable;
import com.erasmus.task2.FirmGenericList;

public class MainTask2bGeneric {
    public static void main(String[] args) {

        System.out.println('\n'+"Employee");
        EmployeeGenericComparable e1 = new EmployeeGenericComparable("Uldis","Petrov",1000.0);
        EmployeeGenericComparable e2 = new EmployeeGenericComparable("Ivars","Stradz",1400.0);
        EmployeeGenericComparable e3 = new EmployeeGenericComparable("Aldis","Zemzars",1200.0);
        System.out.println(e1);
        FirmGenericList f2 = new FirmGenericList("Generic firm");
        f2.addEmployee(e1);
        f2.addEmployee(e2);
        f2.addEmployee(e3);
        System.out.println(f2);

        //Max salary
        System.out.println("Maximal salary: "+f2.getMaxSalary()+'\n');

        //SortingEmployees
        System.out.println("Ascending: ");
        f2.sortSalariesAsc();
        System.out.println(f2);
        System.out.println("Descending: ");
        f2.sortSalariesDesc();
        System.out.println(f2);
    }
}
