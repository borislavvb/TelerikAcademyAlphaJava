package com.telerikAcademyAlpha;

import java.util.HashSet;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            numbers[i-1] = i;
        }


        HashSet<Integer> hs = new HashSet<>();
        getSum(0, arr, numbers,hs);
    }

    private static void getSum(int index, int[] arr, int[] numbers,HashSet<Integer> hs) {

        //HashSet<Integer> hs = new HashSet<>();

        if (index == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("%d ", arr[i]);
            }
            System.out.println();
            return;
        }


        for (int i = 0; i < numbers.length; i++) {
            if (!hs.contains(numbers[i])) {
                arr[index] = numbers[i];
                hs.add(numbers[i]);
                getSum(index + 1, arr, numbers,hs);
                hs.remove(numbers[i]);
            }
        }

    }
}
