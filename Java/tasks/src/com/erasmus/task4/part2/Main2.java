package com.erasmus.task4.part2;

import com.erasmus.task4.part1.Main1;

public class Main2 extends Main1 {
    public static void main(String[] args) {
        int[][] m = createMatrix();
        MatrThreadSum t1, t2;

        t1 = new MatrThreadSum(m, 0, "Even", 2, 1);
        t2 = new MatrThreadSum(m, 1, "Odd", 8, 1);

        t1.getT().start();
        t2.getT().start();

        try {
            t1.getT().join();
            t2.getT().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t1.getT() + ". Sum: " + t1.getSum());
        System.out.println(t2.getT() + ". Sum: " + t2.getSum());
        System.out.println("Total sum: " + Math.addExact(t1.getSum(),t2.getSum()));
    }
}
