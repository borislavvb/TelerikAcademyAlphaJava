package ExamDsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String possibleSubstring = bf.readLine();
        String originalString = bf.readLine();

        System.out.println(solve(possibleSubstring, originalString));
    }

    public static boolean solve(String possible, String origin) {
        if (possible == null || possible.length() == 0) return true;
        int count = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == possible.charAt(count)) {
                count++;
                if (count == possible.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
