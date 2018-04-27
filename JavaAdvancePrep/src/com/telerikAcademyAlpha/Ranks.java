package com.telerikAcademyAlpha;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Ranks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] result = new int[n];
        int[] sorted = new int[n];
        in.nextLine();
        String[] numsStr = in.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(numsStr[i]);
            sorted[i]=arr[i];
        }

        Arrays.sort(sorted);

        for (int i = sorted.length - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (arr[j] == sorted[i]) {
                    result[j] = n - i;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            System.out.printf("%d ", result[j]);
        }
    }
}
