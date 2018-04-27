package com.telerikAcademyAlpha;

import java.util.Scanner;

public class TaynoSaobshtenie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuffer sb = new StringBuffer();

        for (int i = str.length()-1; i >=0 ; i--) {
            if (Character.isLetter(str.charAt(i))){
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
