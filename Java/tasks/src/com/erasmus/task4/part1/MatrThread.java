package com.erasmus.task4.part1;

public class MatrThread extends Thread {
    int[][] m;
    int firstRow;
    int delay;

    public MatrThread(int[][] m, int firstRow, int delay){
        this.m = m;
        this.firstRow = firstRow;
        this.delay = delay;
    }

    public MatrThread(int[][] m, int firstRow, String threadName, int priority, int delay) {
        this.m = m;
        this.firstRow = firstRow;
        this.setName(threadName);
        this.setPriority(priority);
        this.delay = delay;
        this.start();
    }

    @Override
    public void run() {
        int sum;
        for (int i = firstRow; i < m.length; i = i + 2) {
            sum = 0;
            for (int j = 0; j < m[i].length; j++) {
                sum += m[i][j];
                try {
                    Thread.sleep(this.delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println( Thread.currentThread() + ". Row: " + i + ". Sum :" + sum);
        }
    }
}
