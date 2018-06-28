package com.telerikAcademyAlpha;

import java.util.Scanner;

public class BiggestOfFive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = new String[5];
        int index = 0;
        str[0]=in.nextLine();
        double best = Double.valueOf(str[0]);
        for (int i = 1; i < 5; i++) {
            str[i] = in.nextLine();
            if (Double.valueOf(str[i])>best) {
                best = Double.valueOf(str[i]);
                index = i;
            }

        }

        System.out.println(str[index]);
    }
}
