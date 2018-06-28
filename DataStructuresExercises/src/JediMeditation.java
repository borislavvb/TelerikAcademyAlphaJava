import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JediMeditation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] order = in.nextLine().split(" ");
        Queue<String> masters = new LinkedList<>();
        Queue<String> knights = new LinkedList<>();
        Queue<String> padawans = new LinkedList<>();
        //Arrays.stream(order)
        //        .filter(x -> x.charAt(0) == 'M' ? masters.add(x))
        //        .filter(x -> x.charAt(0) == 'K' ? knights.add(x) :)
        //        .filter(x -> x.charAt(0) == 'P' ? padawans.add(x) : );
        for (int i = 0; i < order.length; i++) {
            if (order[i].charAt(0) == 'M') {
                masters.add(order[i]);
            } else if (order[i].charAt(0) == 'K') {
                knights.add(order[i]);
            } else {
                padawans.add(order[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!masters.isEmpty()) {
            sb.append(masters.poll());
            sb.append(" ");
        }
        while (!knights.isEmpty()) {
            sb.append(knights.poll());
            sb.append(" ");
        }
        while (!padawans.isEmpty()) {
            sb.append(padawans.poll());
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
