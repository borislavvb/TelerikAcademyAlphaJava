import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PathToOne {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        queue.add(n);
        queue.add(0);
        while (!queue.isEmpty()){
            int current = queue.poll();
            index = queue.poll();
            if (current==1){
                System.out.println(index);
                return;
            }
            if (current%2==0){
                queue.add(current/2);
                queue.add(index+1);
            }else {
                queue.add(current-1);
                queue.add(index+1);
                queue.add(current+1);
                queue.add(index+1);
            }
        }
    }
}
