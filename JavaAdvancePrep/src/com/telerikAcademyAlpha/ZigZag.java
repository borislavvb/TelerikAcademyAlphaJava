package com.telerikAcademyAlpha;

import java.util.Scanner;

public class ZigZag {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int rows = Integer.parseInt(str[0]);
        int cols = Integer.parseInt(str[1]);
        long result = 1;
        int row = 1;
        int col =1;
        int dRow = +1;
        int dCol = +1;

        while(row<rows){
            result += (row+col)*3 + 1;

            if (col==0 || col == cols - 1){
                dCol *= -1;
                dRow = +1;
            }else{
                dRow *= -1;
            }

            row += dRow;
            col += dCol;
        }

        System.out.println(result);
    }
}
