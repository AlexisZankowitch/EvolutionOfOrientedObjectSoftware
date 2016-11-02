package com.erasmus.task2;

import com.erasmus.task1.Employee;

public class EmployeeComparable extends Employee implements Comparable{

    public EmployeeComparable(String name, String surname, Double salary) {
        super(name, surname, salary);
    }

    @Override
    public int compareTo(Object o) {
        Double s1 = getSalary();
        Double s2 = ((Employee) o).getSalary();
        return (s1<s2)?-1:(s1>s2)?1:0;
    }
}
