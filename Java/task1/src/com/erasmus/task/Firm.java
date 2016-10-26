package com.erasmus.task;

import java.util.Arrays;

/**
 * Created by zankowitch on 26/10/16.
 */
public class Firm {
    private String name;
    private Employee[] employees;
    private int total;

    public Firm(String name, int total) {
        this.name = name;
        this.total = 0;
        this.employees = new Employee[total];
    }

    public void addEmployee(Employee employee){
        try {
            this.employees[this.total]=employee;
            total++;
        }catch (Exception e){
            System.out.println("Maximal amount of employees exceeded !!");
        }
    }

    public String toString(){
        String res = "";
        res += "Firm: " + this.name + ". Amount of employees: " + this.total + '\n';
        for (int i=0;i<this.total;i++){
            res += Math.addExact(i,1) + ". " + employees[i]+'\n';
        }
        return res;
    }
}
