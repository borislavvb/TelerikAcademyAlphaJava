package ExamDsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ToyHDNL {
    private static Queue<String> code = new LinkedList<>();
    private static Stack<String> popedCode = new Stack<>();
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            code.add(bf.readLine());
        }

        String number2 = code.poll();
        while(!code.isEmpty()&&popedCode.isEmpty()){
            StringBuilder spaces= new StringBuilder();
            String number1 = number2;
            number2 =code.poll();

            if (Integer.parseInt(String.valueOf(number1.charAt(1)))<Integer.parseInt(String.valueOf(number2.charAt(1)))){

                result.append(String.format("%s<%s>\n",spaces.toString(),number1));
                popedCode.add(number1);
                spaces.append(" ");
            }else if (Integer.parseInt(String.valueOf(number1.charAt(1)))==Integer.parseInt(String.valueOf(number2.charAt(1)))){
                result.append(String.format("%s<%s>\n",spaces.toString(),number1));
                result.append(String.format("%s</%s>\n",spaces.toString(),number1));
            }else {
                //if (Integer.parseInt(String.valueOf(code.peek().charAt(1)))==number2){
                    String codeChange3 = code.poll();
                    result.append(String.format("%s<%s>\n",spaces.toString(),number1));
                    result.append(String.format("%s</%s>\n",spaces.toString(),number1));
                    spaces.setLength(spaces.length()-1);
                    result.append(String.format("%s</%s>\n",spaces.toString(),number2));
            }
            System.out.println(result);

        }
    }
}
