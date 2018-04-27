package com.telerikAcademyAlpha;

import java.util.Scanner;

public class horsePath2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        //int counter = 1;
        int row = 0;
        int col = 0;
        //matrix[row][col] = counter;

        int[] dRow = {-2, -2, -1, -1, +1, +1, +2, +2};
        int[] dCol = {-1, +1, -2, +2, -2, +2, -1, +1};
        int counter = 1;
        while(counter<=n*n) {

            matrix[row][col] = counter;
            for (int i = 0; i < dRow.length; i++) {
                if (row + dRow[i] >= 0 && row + dRow[i] < n && col + dCol[i] >= 0 && col + dCol[i] < n && matrix[row + dRow[i]][col + dCol[i]] == 0) {
                    counter++;
                    row += dRow[i];
                    col += dCol[i];
                    break;
                }

            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j]==0){
                        counter++;
                        matrix[i][j]=counter;
                    }
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.println();
        }
    }
}
