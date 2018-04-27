package com.telerikAcademyAlpha;

import java.math.BigInteger;
import java.util.Scanner;

public class nFactorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(findFactorial(n));
    }

    private static BigInteger findFactorial(long n) {
        if (n==1){
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(n).multiply(findFactorial(n-1));
    }
}
