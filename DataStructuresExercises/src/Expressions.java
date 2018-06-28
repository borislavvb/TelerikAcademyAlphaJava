import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Expressions {
    private static boolean[] check;
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        int index = 0;
        ArrayList<String> arr = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i)=='('){
                stack.push(i);
            }
            if (expression.charAt(i)==')'){
                int first = stack.pop();
                int second = i;
                arr.add(expression.substring(first,second+1));
            }
        }
        arr.stream()
                .forEach(System.out::println);
    }
}
