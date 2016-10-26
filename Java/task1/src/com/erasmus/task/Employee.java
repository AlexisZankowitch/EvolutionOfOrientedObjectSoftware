package com.erasmus.task;

/**
 * Created by zankowitch on 26/10/16.
 */
public class Employee extends Human {
    private Double salary;

    public Employee(String name, String surname,Double salary) {
        super(name, surname);
        this.salary = salary;
    }

    public Employee(Employee employee){
        super(employee);
        this.salary = employee.getSalary();
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString()+"Salary=" + salary+" EUR.";
    }
}
