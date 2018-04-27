package com.telerikAcademyAlpha;

import java.util.Scanner;

public class BitConvert {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(",");
        int[] numbers = new int[strArr.length];
        String[] binary = new String[numbers.length];
        for (int i = 0; i < strArr.length; i++) {
            numbers[i] = Integer.parseInt(strArr[i]);
            binary[i]=Integer.toBinaryString(numbers[i]);
            if (binary[i].length()>8){
                binary[i] = binary[i].substring(binary[i].length()-8);
            }if (binary[i].length()<8){
                int zerosNeeded = 8 - binary[i].length();
                for (int j = 0; j < zerosNeeded; j++) {
                    binary[i] = "0" + binary[i];
                }
            }
        }

        String result = "";

        for (int i = 1; i <= binary.length; i++) {
            if (i%2==0){
                for (int j = 1; j <= binary[i-1].length(); j++) {
                    if (j%2==1){
                        result += binary[i-1].charAt(j-1);
                    }
                }
            }else {
                for (int j = 1; j <= binary[i-1].length(); j++) {
                    if (j%2==0){
                        result += binary[i-1].charAt(j-1);
                    }
                }
            }
        }

        System.out.println(result.toString());
    }
}
