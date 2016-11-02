package com.erasmus.task2;

import com.erasmus.task1.Employee;
import com.erasmus.task1.Firm;

import java.util.Arrays;
import java.util.Comparator;

public class FirmComparator extends Firm {

    protected static class SaleDesc implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            Double s1 = ((Employee) o1).getSalary();
            Double s2 = ((Employee) o2).getSalary();
            return (s1>s2)?-1:(s1<s2)?1:0;
        }
    }

    public FirmComparator(String name, int total) {
        super(name, total);
    }

    public void sortSalariesAsc(){
        Arrays.sort(this.employees,0,this.total);
    }

    public void sortSalariesDesc(){
        Arrays.sort(this.employees,0,this.total,new SaleDesc());
    }

    public double getMaxSalary(){
        Double max = this.employees[0].getSalary();
        for (int i=1; i< this.total ;i++){
            if(this.employees[i].getSalary() > max)
                max = this.employees[i].getSalary();
        }
        return max;
    }
}
