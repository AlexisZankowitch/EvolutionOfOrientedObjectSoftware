package com.erasmus.task4.part2;

public class MatrThreadSum implements Runnable {
    int[][] m;
    int firstRow;
    int delay;

    private Thread t;
    private int sum;


    MatrThreadSum(int[][] m, int firstRow, String name, int priority, int delay) {
        this.delay = delay;
        this.firstRow = firstRow;
        this.m = m;
        t = new Thread(this, name);
        t.setPriority(priority);
    }

    @Override
    public void run() {
        sum = 0;
        for (int i = this.firstRow; i < m.length; i = i +2) {
            for (int j = 0; j < m[i].length; j++) {
                this.sum += m[i][j];
            }
        }
    }

    int getSum() {
        return sum;
    }

    Thread getT() {
        return t;
    }
}
