package com.telerikAcademyAlpha;

import java.util.Scanner;

public class JoroTheNaughty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int jumps = Integer.parseInt(str[2]);

        int[][] matrix = new int[n][m];
        boolean[][] boolMatrix = new boolean[n][m];
        int counter = 1;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                matrix[i][k] = counter;
                counter++;
            }
        }
        int startRow = in.nextInt();
        int startCol = in.nextInt();
        in.nextLine();
        int[] dRow = new int[jumps];
        int[] dCol = new int[jumps];

        for (int i = 0; i < jumps; i++) {
            String[] moves = in.nextLine().split(" ");
            dRow[i] = Integer.parseInt(moves[0]);
            dCol[i] = Integer.parseInt(moves[1]);
        }

        boolean caught = false;
        boolean escaped = false;
        boolean isJumping = true;
        int row = startRow;
        int col = startCol;
        long sumNums = 0;
        int jumpCounter = 0;
        int nextRow = 0;
        int nextCol = 0;
        sumNums += matrix[row][col];

        while (isJumping) {
            for (int i = 0; i < jumps; i++) {
                nextRow = row+dRow[i];
                nextCol = col + dCol[i];

                if (!(isInMatrix(nextRow,n)&&isInMatrix(nextCol,m))){
                    isJumping=false;
                    escaped = true;
                    //jumpCounter++;
                    break;
                }
                if (boolMatrix[nextRow][nextCol]==true){
                    jumpCounter++;
                    caught=true;
                    isJumping=false;
                    break;
                }

                row = nextRow;
                col = nextCol;
                sumNums += matrix[row][col];
                jumpCounter++;

            }
        }

        if (caught){
            System.out.printf("caught %d",jumpCounter);
        }
        if (escaped){
            System.out.printf("escaped %d",sumNums);
        }
    }

    private static boolean isInMatrix(int r, int max) {
        return (0<=r)&&(r<max);
    }
}
