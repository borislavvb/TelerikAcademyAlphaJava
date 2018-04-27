package com.telerikAcademyAlpha;

import java.util.ArrayList;
import java.util.Scanner;

public class Numeroogy {
    private static int[] digitCOunt= new int[10];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split("");
        ArrayList<Integer> arrInt = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            arrInt.add(Integer.parseInt(arr[i]));
        }
        divine(arrInt);
        for (int i = 0; i < digitCOunt.length; i++) {
            System.out.printf("%d ",digitCOunt[i]);
        }
    }
    public static void divine(ArrayList<Integer> digits){
        if (digits.size()==1){
            ++digitCOunt[digits.get(0)];
            return;
        }

        for (int i = 1; i < digits.size(); i++) {
            int a = digits.get(i-1);
            int b = digits.get(i);
            digits.remove(i);
            digits.set(i-1,magic(a,b));
            divine(digits);
            digits.set(i-1,a);
            digits.add(i,b);
        }
    }
    public static int magic(int a, int b){
        return (a+b)*(a^b)%10;
    }
}
