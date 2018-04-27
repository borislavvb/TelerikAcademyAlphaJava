package com.telerikAcademyAlpha;

import java.util.Scanner;

public class Indices {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] arr = in.nextLine().split(" ");
        int[] indexes = new int[n];
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {
            indexes[i] = Integer.parseInt(arr[i]);
        }

        for (int index = 0; index < n; index++) {
            if (indexes[index] < n-1){
                //sb.append();
            }
        }
    }
}
