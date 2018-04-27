package com.telerikAcademyAlpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class TwoMakeASum2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(in.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long sumsDone = 0;
        int[] nums = Arrays.stream(in.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i:nums){
            sumsDone += checkPair(numbers,i);
        }
        System.out.println(sumsDone);
    }

    private static long checkPair(int[] numbers, int sum) {
        int k =0;
        int m = numbers.length-1;
        int result =0;
        while (k<m){
            if (numbers[k]+numbers[m]==sum){
                result++;
                k++;
            }else if(numbers[k]+numbers[m]<sum){
                k++;
            }else {
                m--;
            }
        }
        return result;
    }
}