package com.erasmus.task5;

import com.erasmus.task4.part1.Main1;

public class Main extends Main1{
    public static void main(String[] args) {
        int[][] M = createMatrix();
        MatrFun matrFun = new MatrFun();
        new Matr(M,"even",0,5,matrFun);
        new Matr(M,"odd",1,5,matrFun);
    }
}
