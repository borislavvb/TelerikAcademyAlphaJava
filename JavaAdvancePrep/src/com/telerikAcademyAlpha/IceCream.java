package com.telerikAcademyAlpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class IceCream {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int counter = 0;
        for (int i = 0; i < input[1].length(); i++) {
            if (input[1].charAt(i)=='0'){
                counter++;
            }
        }

            System.out.println((n-input[1].length())+counter);
    }
}
