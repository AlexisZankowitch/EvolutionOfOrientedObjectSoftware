package com.erasmus.task4.part1;

import java.util.Arrays;

public class Main1 {

    private final static int nbM = 7;

    public static void main(String[] args) {

        int[][] m = createMatrix();

        /*System.out.println('\n'+ "Thread inheritance: ");
        new MatrThread(m, 0, "Even", 2, 0);
        new MatrThread(m, 1, "odd", 2, 0);*/

        System.out.println('\n'+ "Thread runnable implementation: ");
        new MatrThreadRunnable(m, 0, "Even", 2, 1);
        new MatrThreadRunnable(m, 1, "odd", 4, 1);
    }

    protected static int[][] createMatrix(){
        System.out.println("Matrix: ");
        int [][] m = new int[nbM][nbM];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = i+1;
            }
            System.out.println(Arrays.toString(m[i]));
        }
        return m;
    }
}
