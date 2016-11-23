package com.erasmus.task5;

public class MatrFun {

     public void printRow(int row, int M[][]) throws InterruptedException {
        System.out.print("Row: ");
        Thread.sleep(0);
        System.out.print(row);
        Thread.sleep(0);
        System.out.print(". Elements: ");
        Thread.sleep(0);
        for (int j = 0; j < M[row].length; j++) {
            System.out.print(M[row][j] + " ");
            Thread.sleep(10);
        }
        System.out.print('\n');
        Thread.sleep(0);
    }
}
