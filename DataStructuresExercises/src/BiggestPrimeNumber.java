import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BiggestPrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        for (int i = n; i > 0; i--) {
            if (primeCheck(i)){
                System.out.println(i);
                break;
            }
        }

    }

    private static boolean primeCheck(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i%j==0){
                return false;
            }
        }
        return true;
    }

}
