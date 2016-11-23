package com.erasmus.task5;

public class Matr implements Runnable{
    private int[][] M;
    private int startRow;
    private final MatrFun matrFun;

    Matr(int[][] m, String name, int startRow, int priority, MatrFun matrFun) {
        M = m;
        this.startRow = startRow;
        Thread t = new Thread(this, name);
        this.matrFun = matrFun;
        t.setPriority(priority);
        t.start();
    }

    @Override
    public void run() {
        for (int i = this.startRow; i < M.length; i = i+2) {
            synchronized (this.matrFun){
                try {
                    this.matrFun.printRow(i, this.M);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
