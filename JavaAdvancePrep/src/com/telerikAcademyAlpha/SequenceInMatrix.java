package com.telerikAcademyAlpha;

import java.util.Scanner;

public class SequenceInMatrix {
    static int n;
    static int m;
    private int[][] matrix = new int[n][m];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        int[][] matrix = new int[n][m];
        int counter = 1;
        int best = 1;

        for (int i = 0; i < n; i++) {
            String[] str2 = in.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(str2[j]);
                if (j != m - 1 && matrix[i][j] == matrix[i][j + 1]) {
                    counter++;
                } else {
                    if (counter > best) {
                        best = counter;
                        counter = 1;
                    } else {
                        counter = 1;
                    }
                }
            }
            if (counter>best){
                best = counter;
                counter =1;
            }else {
                counter=1;
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[j][i] == matrix[j + 1][i]) {
                    counter++;
                } else {
                    if (counter > best) {
                        best = counter;
                        counter = 1;
                    } else {
                        counter = 1;
                    }
                }
            }
            if (counter>best){
                best = counter;
                counter=1;
            }else {
                counter=1;
            }
        }

        System.out.println(best);
    }

}
