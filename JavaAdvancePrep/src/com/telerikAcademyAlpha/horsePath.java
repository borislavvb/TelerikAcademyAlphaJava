package com.telerikAcademyAlpha;

import java.util.Scanner;

public class horsePath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        int counter =1;

        int row = 0;
        int col = 0;
        matrix[row][col]=1;


        while(counter <= n*n){

            if (row-2>=0 && col-1>=0&& matrix[row-2][col-1]==0){ //top left corner
                counter++;
                row -= 2;
                col -=1;
                matrix[row][col] = counter;
            }else if (row-2>=0&&col+1<=n-1&&matrix[row-2][col+1]==0){
                counter++;
                row -= 2;
                col += 1;
                matrix[row][col] = counter;
            }else if (row-1>=0&&col-2>=0&&matrix[row-1][col-2]==0){
                counter++;
                row -= 1;
                col -= 2;
                matrix[row][col] = counter;
            }else if (row-1>=0&&col+2<n&&matrix[row-1][col+2]==0){
                counter++;
                row -= 1;
                col += 2;
                matrix[row][col] = counter;
            }else if (row+1<n&&col-2>=0&&matrix[row+1][col-2]==0){
                counter++;
                row += 1;
                col -= 2;
                matrix[row][col]=counter;
            }else if (row+1<n&&col+2<n&&matrix[row+1][col+2]==0){
                counter++;
                row += 1;
                col += 2;
                matrix[row][col]=counter;
            }else if (row+2<n && col-1>=0&&matrix[row+2][col-1]==0){
                counter++;
                row += 2;
                col -= 1;
                matrix[row][col] = counter;
            }else if (row +2 <n && col +1 <n&&matrix[row+2][col+1]==0){
                counter++;
                row += 2;
                col += 1;
                matrix[row][col] = counter;
            }else{
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        if (matrix[r][c]==0){
                            counter++;
                            matrix[r][c]=counter;
                            break;
                        }
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
