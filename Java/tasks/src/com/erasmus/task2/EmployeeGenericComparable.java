package com.erasmus.task2;

import com.erasmus.task1.Employee;

public class EmployeeGenericComparable extends Employee implements Comparable<EmployeeGenericComparable> {

    public EmployeeGenericComparable(String name, String surname, Double salary) {
        super(name, surname, salary);
    }

    @Override
    public int compareTo(EmployeeGenericComparable o) {
        Double s1 = getSalary();
        Double s2 = o.getSalary();
        return (s1<s2)?-1:(s1>s2)?1:0;
    }
}
