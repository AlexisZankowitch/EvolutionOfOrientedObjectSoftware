package com.erasmus.task4.part1;

class MatrThreadRunnable implements Runnable {
    Thread t;
    int[][] m;
    int firstRow;
    int delay;

    MatrThreadRunnable(int[][] m, int firstRow, String name, int priority, int delay) {
        this.delay = delay;
        this.firstRow = firstRow;
        this.m = m;
        t = new Thread(this);
        t.setName(name);
        t.setPriority(priority);
        t.start();
    }

    @Override
    public void run() {
        int sum;
        for (int i = firstRow; i < m.length; i = i + 2) {
            sum = 0;
            for (int j = 0; j < m[i].length; j++) {
                sum += m[i][j];
                try {
                    t.sleep(this.delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println( Thread.currentThread() + ". Row: " + i + ". Sum :" + sum);
        }
    }
}
