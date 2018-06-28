import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Homework {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int counter = 2;
        int p =0;
        while (counter<=Math.sqrt(n)){
            if (n%counter==0){
                p=counter;
                break;
            }else {
                counter++;
            }
        }
        if (counter>Math.sqrt(n)) {
            System.out.println(n-1);
        }else {
            System.out.println(n-n/p);
        }
    }
}
