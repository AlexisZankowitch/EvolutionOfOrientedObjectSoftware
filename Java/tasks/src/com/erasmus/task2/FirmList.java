package com.erasmus.task2;

import com.erasmus.task1.Employee;

import java.util.*;

public class FirmList {
    private ArrayList employees;
    private String name;

    public FirmList(String name) {
        this.name = name;
        this.employees = new ArrayList();
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public Double getMaxSalary(){
        Double max = ((Employee) this.employees.get(0)).getSalary();
        for (int i = 1; i < this.employees.size(); i++) {
            max = (max<((Employee)this.employees.get(i)).getSalary())?((Employee)this.employees.get(i)).getSalary():max;
        }
        return max;
    }

    public void sortSalariesAsc(){
        Collections.sort(this.employees);
    }

    public void sortSalariesDesc(){
        this.employees.sort(new FirmComparator.SaleDesc());
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
