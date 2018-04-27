package com.telerikAcademyAlpha;

import java.util.Scanner;

public class Kitty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] positions = in.nextLine().toCharArray();
        String[] movesStr = in.nextLine().split(" ");
        long[] moves = new long[movesStr.length];
       long souls = 0;
        long food = 0;
        long deadlock = 0;
        int index = 0;
        boolean dead = false;
        long counter = 0;

        for (int i = 0; i < moves.length; i++) {
            counter++;
            moves[i] = Integer.parseInt(movesStr[i]);
        }
        if (positions[0] == '@') {
            souls++;
            positions[0] = '0';
        } else if (positions[0] == '*') {
            food++;
            positions[0] = '0';
        } else {
            dead = true;
            System.out.println("You are deadlocked, you greedy kitty!");
            System.out.println("Jumps before deadlock: 0");
            return;
        }
        for (int i = 0; i < moves.length; i++) {
            index += moves[i];
            if (index < 0) {
               while(index<0){
                   index += positions.length;
               }
            }
            if (index >= positions.length) {
                while (index>=positions.length){
                    index -= positions.length;
                }
            }

            if (positions[index] == '@') {
                souls++;
                positions[index] = '0';
            } else if (positions[index] == '*') {
                food++;
                positions[index] = '0';
            } else if (positions[index] == 'x') {
                if (index % 2 == 0) {
                    if (souls > 0) {
                        souls--;
                        positions[index] = '@';
                        deadlock++;
                    } else {
                        System.out.println("You are deadlocked, you greedy kitty!");
                        System.out.printf("Jumps before deadlock: %d", counter);
                        break;
                    }
                } else {
                    if (food > 0) {
                        food--;
                        positions[index] = '*';
                        deadlock++;
                    } else {
                        System.out.println("You are deadlocked, you greedy kitty!");
                        System.out.printf("Jumps before deadlock: %d", counter);
                        break;
                    }
                }
            }
        }

        if (!dead){
            System.out.printf("Coder souls collected: %d\n",souls);
            System.out.printf("Food collected: %d\n",food);
            System.out.printf("Deadlocks: %d",deadlock);
        }
    }
}
