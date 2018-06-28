import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Swapping {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(in.readLine());
        //in.nextLine();
        LinkedList<Integer> result = new LinkedList<>();

        //Queue<Integer> temp = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            result.add(i+1);
        }
        String[] keysStr = in.readLine().split(" ");
        int[] keys = new int[keysStr.length];

        for (int i = 0; i < keys.length; i++) {
            keys[i]=Integer.parseInt(keysStr[i]);
            int index = result.indexOf(keys[i]);
            result.addFirst(keys[i]);
            Collections.swap(result,index,result.size());
            result.removeLast();

        }

        while (!result.isEmpty()){
            System.out.printf("%d ",result.poll());
        }


    }
}
