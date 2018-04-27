package com.telerikAcademyAlpha;

import java.util.Scanner;

public class BitConvert2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        int[] numbers = new int[str.length];
        String[] binaryStr = new String[str.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            numbers[i] =  Integer.parseInt(str[i]);
            binaryStr[i] = Integer.toBinaryString(numbers[i]);
            if (binaryStr[i].length()>8){
                binaryStr[i] = binaryStr[i].substring(binaryStr[i].length()-8);
            }else if ( binaryStr[i].length()>0 && binaryStr[i].length()<8){
                while (binaryStr[i].length()!=8) {
                    binaryStr[i] = "0" + binaryStr[i];
                }
            }
        }

        for (int i = 0; i < binaryStr.length; i++) {
            if (i%2==0){
                for (int j = 0; j < binaryStr[i].length(); j++) {
                    if (j%2==1){
                        sb.append(binaryStr[i].charAt(j));
                    }
                }
            }else {
                for (int j = 0; j < binaryStr[i].length(); j++) {
                    if (j%2==0){
                        sb.append(binaryStr[i].charAt(j));
                    }
                }

        }
    }System.out.println(sb.toString());

    }
}
