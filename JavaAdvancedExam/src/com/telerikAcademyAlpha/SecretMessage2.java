package com.telerikAcademyAlpha;

import java.util.Scanner;

public class SecretMessage2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        decode(message, 0);
    }

    private static void decode(String message, int currentIndex) {
        int index = currentIndex;

        while (index < message.length()) {
            char currentCHar = message.charAt(index);
            String number = "";
            while (!Character.isDigit(currentCHar)) {

                number += currentCHar;
            }
            while (Character.isLetter(currentCHar)) {
                index++;
            }

        }
        // String encodeMessage= message.substring(startIndex,index)
    }
}

