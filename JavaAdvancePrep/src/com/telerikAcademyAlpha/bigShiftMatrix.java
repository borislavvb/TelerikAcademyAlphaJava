package com.telerikAcademyAlpha;

import java.math.BigInteger;
import java.util.Scanner;

public class bigShiftMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int operations = in.nextInt();
        in.nextLine();
        String[] movesStr = in.nextLine().split(" ");
        int[] moves = new int[operations];
        boolean[][] matrix = new boolean[rows][cols];
        int coeff = Math.max(rows, cols);
        for (int i = 0; i < operations; i++) {
            moves[i] = Integer.parseInt(movesStr[i]);
        }

        int row = rows - 1;
        int col = 0;

        for (int i = 0; i < operations; i++) {
            int nextRow = getRow(moves[i], coeff);
            int nextCol = getCol(moves[i], coeff);

            int colDir = col < nextCol
                    ? +1
                    : -1;

            while (col != nextCol) {
                matrix[row][col] = true;
                col += colDir;
            }

            int rowDir = row < nextRow
                    ? +1
                    : -1;

            while (row != nextRow) {
                matrix[row][col] = true;
                row += rowDir;
            }

        }
        matrix[row][col] = true;

        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j]) {
                    BigInteger cellValue = getValue(rows - 1 - i, j);

                    result = result.add(cellValue);
                }
            }
        }

        System.out.println(result);

        //for (int i = 0; i < rows; i++) {
        //    for (int j = 0; j < cols; j++) {
        //        System.out.printf("%b ", matrix[i][j]);
        //    }
        //    System.out.println();
        //}

    }

    public static int getRow(int move, int coeff) {
        return move / coeff;
    }

    public static int getCol(int move, int coeff) {
        return move % coeff;
    }

    private static BigInteger getValue(int row, int col) {
        int power = row + col;
        return BigInteger.TWO.pow(power);

    }
}
