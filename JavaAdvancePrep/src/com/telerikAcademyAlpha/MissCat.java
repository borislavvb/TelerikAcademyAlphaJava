package com.telerikAcademyAlpha;

import java.util.ArrayList;
import java.util.Scanner;

public class MissCat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int judges = in.nextInt();
        int[] votes = new int[10];
        int current = 0;
        int best = 0;
        int cat = 0;

        for (int i = 0; i < judges; i++) {
            int num = in.nextInt();
            votes[num-1]+= 1;
        }
        for (int i = 0; i < 10; i++) {
            if (votes[i]>best){
                cat = i+1;
                best=votes[i];
            }
        }
        System.out.println(cat);
    }
}
