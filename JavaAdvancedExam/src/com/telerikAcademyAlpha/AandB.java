package com.telerikAcademyAlpha;

import java.util.Scanner;

public class AandB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int index = 0;
        String[] str = in.nextLine().split(" ");
        int[] ab = new int[2];
        int[] result = new int[n];

        if (Integer.parseInt(str[0]) > Integer.parseInt(str[1])) {
            ab[1] = Integer.parseInt(str[0]);
            ab[0] = Integer.parseInt(str[1]);
        } else {
            ab[1] = Integer.parseInt(str[1]);
            ab[0] = Integer.parseInt(str[0]);
        }

        variationMaker(ab, result, n, 0);
    }

    private static void variationMaker(int[] ab, int[] result, int n, int index) {
        if (result.length == index) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
            }
            System.out.println();
            return;
        }

        for (int j = 0; j < ab.length; j++) {
            result[index] = ab[j];
            variationMaker(ab, result, n, index + 1);
        }
    }
}
