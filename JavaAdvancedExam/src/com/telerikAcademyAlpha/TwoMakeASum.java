package com.telerikAcademyAlpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoMakeASum {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(in.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long sumsDone = 0;
        int[] nums = Arrays.stream(in.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        //String[] str = in.readLine().split("\\s");
        //int[] numbers = new int[str.length];
        //for (int i = 0; i < str.length; i++) {
        //    numbers[i] = Integer.parseInt(str[i]);
        //}
        //String[] str2 = in.readLine().split("\\s");
        //int[] nums = new int[str2.length];
        //for (int i = 0; i < str2.length; i++) {
        //    nums[i] = Integer.parseInt(str2[i]);
        //}
        for (int k = 0; k < nums.length; k++) {
            int i = 0;
            int r = numbers.length - 1;
            while (i < r) {
                if (numbers[i] + numbers[r] == nums[k]) {
                    sumsDone++;
                    i++;
                } else if (numbers[i] + numbers[r] < nums[k]) {
                    i++;
                } else {
                    r--;
                }
            }
        }

        System.out.println(sumsDone);
    }
}
