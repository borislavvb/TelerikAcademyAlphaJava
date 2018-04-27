package com.telerikAcademyAlpha;

import java.util.HashSet;
import java.util.Scanner;

public class OddNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashSet<Long> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            long number = in.nextLong();
            if (hs.contains(number)){
                hs.remove(number);
            }else {
                hs.add(number);
            }
        }
        for (long num :hs) {
            System.out.println(num);
        }
    }
}
