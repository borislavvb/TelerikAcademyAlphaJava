package com.telerikAcademyAlpha;

import java.util.Scanner;

public class SecretMessage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(getResult(input));
    }

    private static String getResult(String input) {
        String lettersBegining= "";
        String numbers = "0";


        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i))){
                lettersBegining += input.charAt(i);
            }else if (Character.isDigit(input.charAt(i))){
                numbers += input.charAt(i);
            } else if (input.charAt(i) =='{') {
                String next = input.substring(i+1);
                String repeat = getResult(next);
                String cons= "";
                int iterations = Integer.parseInt(numbers);
                for (int j = 0; j < iterations; j++) {
                    cons += repeat;
                }
                lettersBegining += cons;
            }else if (input.charAt(i)=='}'){

                return lettersBegining.toString();
            }
        }
        System.out.println(lettersBegining);
        return lettersBegining.toString();

    }
}
