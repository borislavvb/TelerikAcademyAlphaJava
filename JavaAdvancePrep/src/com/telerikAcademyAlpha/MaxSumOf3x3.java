package com.telerikAcademyAlpha;



import java.util.Scanner;


public class MaxSumOf3x3 {

    private static int n;
    private static int m;
    private static int[][] nums;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] str = in.nextLine().split(" ");
        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);
        nums= new int[n][m];


        for (int i = 0; i < n; i++) {
            String[] strNums = in.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                nums[i][j]=Integer.parseInt(strNums[j]);
            }
        }
        long bestSum = Long.MIN_VALUE;

        for (int i = 0; i <n-2; i++) {
            long tempSum =  Long.MIN_VALUE;
            for (int j = 0; j < m-2; j++) {
                tempSum = nums[i][j] + nums[i][j+1]+nums[i][j+2]+nums[i+1][j]+nums[i+1][j+1]+nums[i+1][j+2]+nums[i+2][j]+nums[i+2][j+1]+nums[i+2][j+2];
                if (tempSum>bestSum){
                    bestSum = tempSum;
                    tempSum = Long.MIN_VALUE;
                }else {
                    tempSum = Long.MIN_VALUE;
                }
            }
        }

        System.out.println(bestSum);
    }
}
