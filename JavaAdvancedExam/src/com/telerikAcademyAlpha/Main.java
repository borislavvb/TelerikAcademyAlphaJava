package com.telerikAcademyAlpha;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int coinsCounter = 0;
        int[][] matrix = new int[n][m];
        boolean isThereAPath = true;
        int row = 0;
        int col = 0;
        for (int r = 0; r < n; r++) {
            String[] numbers = in.nextLine().split(" ");
            for (int c = 0; c < m; c++) {
                matrix[r][c]=Integer.parseInt(numbers[c]);
                if (matrix[r][c]==0){
                    row = r;
                    col = c;
                }
            }
        }

        int[] dRow = {0,0,-1,1};
        int[] dCol = {-1,1,0,0};

        while(isThereAPath){
            int nextRow = row;
            int nextCol = col;
            int biggestAmount = 0;
            int bestIndex = 0;

            for (int i = 0; i < 4; i++) {
                if (inMatrix(row+dRow[i],n)&&inMatrix(col+dCol[i],m)){
                    if (matrix[nextRow+dRow[i]][nextCol+dCol[i]]>biggestAmount){
                        biggestAmount = matrix[nextRow+dRow[i]][nextCol+dCol[i]];
                        bestIndex = i;
                    }
                }
            }

            if (biggestAmount>0){
                matrix[nextRow][nextCol]--;
                coinsCounter++;
                biggestAmount = 0;
                row += dRow[bestIndex];
                col += dCol[bestIndex];
            }else{
                isThereAPath = false;
            }

        }
        System.out.println(coinsCounter);
    }

    private static boolean inMatrix(int num, int max) {
        return (0<=num)&&(num < max);
    }
}
