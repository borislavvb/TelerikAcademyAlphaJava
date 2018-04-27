package com.telerikAcademyAlpha;

import java.util.Scanner;

public class GreedyDwarf {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] matrix = new int[n][m];
        int row = 0;
        int col = 0;
        int nextRow = 0;
        int nextCol = 0;
        int coinsCount = 0;

        for (int i = 0; i < n; i++) {
            String[] str2 = in.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(str2[j]);
                if (matrix[i][j] == 0) {
                    row = i;
                    col = j;
                }
            }
        }

        int[] dRow = {0, 0, -1, +1};
        int[] dCol = {-1, +1, 0, 0};

        boolean isThereAPath = true;
        while (isThereAPath) {
            int bestWay = 0;
            for (int i = 0; i < 4; i++) {
                if (isInMatrix(row + dRow[i], n) && isInMatrix(col + dCol[i], m) && matrix[row + dRow[i]][col + dCol[i]] != 0) {
                    if (matrix[row + dRow[i]][col + dCol[i]] > bestWay) {
                        bestWay = matrix[row + dRow[i]][col + dCol[i]];
                        nextCol = col + dCol[i];
                        nextRow = row + dRow[i];
                    }
                }
            }
            if (bestWay>0) {
                matrix[nextRow][nextCol]--;
                row = nextRow;
                col = nextCol;
                coinsCount++;
                bestWay = 0;
            }else {
                isThereAPath = false;
            }

        }
        System.out.println(coinsCount);
    }

    private static boolean isInMatrix(int i, int m) {
        return (0 <= i) && (i < m);
    }
}
