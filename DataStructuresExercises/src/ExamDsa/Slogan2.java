package ExamDsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Slogan2 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            String[] words = bf.readLine().split(" ");
            String slogan = bf.readLine();
            ArrayList<String> usedWords = new ArrayList<>();

            HashSet<String> cantFix;
            if (sloganCheck(slogan, words, new HashSet<>(), usedWords)) {
                sb.append(String.join(" ",usedWords));
                sb.append("\n");
            } else {
                sb.append("NOT VALID\n");
            }

        }
        System.out.println(sb);
    }

    private static boolean sloganCheck(String slogan, String[] words, HashSet<String> impossibleSlogan, ArrayList<String> usedWords) {
        for (String word : words) {
            if (!slogan.startsWith(word)) {
                continue;
            }

            String newSlogan = slogan.substring(word.length());
            if (impossibleSlogan.contains(newSlogan)) {
                continue;
            }

            usedWords.add(word);
            if (newSlogan.length() == 0) {
                return true;
            }

            if (sloganCheck(newSlogan, words, impossibleSlogan, usedWords)) {
                return true;
            }

        }
        impossibleSlogan.add(slogan);
        return false;
    }
}
