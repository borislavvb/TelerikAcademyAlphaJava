package ExamDsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class GreaterMoney2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = bf.readLine().split(",");
        String[] str2 = bf.readLine().split(",");
        int[] bag1 = new int[str1.length];
        int[] bag2 = new int[str2.length];
        HashSet<Integer> used = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bag2.length; i++) {
            if (i < bag1.length) {
                bag1[i] = Integer.parseInt(str1[i]);
                bag2[i] = Integer.parseInt(str2[i]);
            } else {
                bag2[i] = Integer.parseInt(str2[i]);
            }
        }
        int counter = 0;
        for (int i = 0; i < bag1.length; i++) {
            sb.append(solve(bag1[i],bag2));
            sb.append(",");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    private static int solve(int num, int[] bag2) {
        for (int j = 0; j < bag2.length; j++) {
            if (num==bag2[j]){
                for (int i = j+1; i < bag2.length; i++) {
                    if (num<bag2[i]){
                        return bag2[i];
                    }
                }
            }
        }
        return -1;
    }
}
