package com.telerikAcademyAlpha;

import java.util.Scanner;



public class Bounce {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int rows = Integer.parseInt(str[0]);
        int cols = Integer.parseInt(str[1]);

        long result = getValue(0,0);
        int row = 1;
        int col = 1;
        int dRow = +1;
        int dCol = +1;

        if (rows ==1 || cols ==1){
            System.out.println(getValue(0,0));
            return;
        }

        while (!atCorner(row, col, rows, cols)) {
            result += getValue(row,col);

            int nextRow = row + dRow;
            int nextCol = col + dCol;

            if (nextRow < 0 || nextRow > rows-1){
                dRow *= -1;
            }
            if (nextCol<0 || nextCol > cols -1){
                dCol *= -1;
            }

            row += dRow;
            col += dCol;
        }
        result += getValue(row,col);
        System.out.println(result);
    }

    private static long getValue(int row, int col) {
        int power = row + col;
        return (long) Math.pow(2,power);
    }

    private static boolean atCorner(int row, int col, int rows, int cols) {
        return (row == 0 && col == 0) ||
                (row == 0 && col == cols - 1) ||
                (row == rows - 1 && col == 0) ||
                (row == rows - 1 && col == cols - 1);
    }
}
