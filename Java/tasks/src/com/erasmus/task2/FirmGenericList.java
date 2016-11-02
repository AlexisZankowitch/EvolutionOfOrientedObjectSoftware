package com.erasmus.task2;

import com.erasmus.task1.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FirmGenericList {
    private final String name;
    private ArrayList<EmployeeGenericComparable> employees;

    private static class SaleDesc implements Comparator<EmployeeGenericComparable> {
        @Override
        public int compare(EmployeeGenericComparable o1, EmployeeGenericComparable o2) {
            Double s1 = o1.getSalary();
            Double s2 = o2.getSalary();
            return (s1>s2)?-1:(s1<s2)?1:0;
        }
    }

    public FirmGenericList(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(EmployeeGenericComparable employee) {
        this.employees.add(employee);
    }

    public Double getMaxSalary() {
        Double max = this.employees.get(0).getSalary();
        for (int i = 1; i < this.employees.size(); i++) {
            max = (max<this.employees.get(i).getSalary())?this.employees.get(i).getSalary():max;
        }
        return max;
    }

    public void sortSalariesAsc(){
        Collections.sort(this.employees);
    }

    public void sortSalariesDesc(){
        Collections.sort(this.employees,new SaleDesc());
    }

    public String toString(){
        String res = "";
        res += "Firm: " + this.name + ". Amount of employees: " + this.employees.size() + '\n';
        for (int i=0;i<this.employees.size();i++){
            res += Math.addExact(i,1) + ". " + employees.get(i)+'\n';
        }
        return res;
    }
}
