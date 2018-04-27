package com.telerikAcademyAlpha;

import java.util.Scanner;

public class BiggestOfFive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = new String[5];
        int index = 0;
        str[0]=in.nextLine();
        double best = Double.MIN_VALUE;
        for (int i = 1; i < 5; i++) {
            str[i] = in.nextLine();
            if (Double.valueOf(str[i])>Double.valueOf(str[i-1])) {
                best = Double.valueOf(str[i]);
                index = i;
            }{
                best = Double.valueOf(str[i-1]);
                index = i-1;
            }

        }

        System.out.println(str[index]);
    }
}
