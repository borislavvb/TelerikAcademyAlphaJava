import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class LargestRectangleInHistogram {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] h = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int best = findMax(h,0,h.length-1);
    }

    private static int findMax(int[] h, int start, int end) {
        int index = getIndexOfMin(h,start,end);

        int left = findMax(h,start,index-1);
        int current = h[index]*(end-start+1);
        int right = findMax(h,start+1,end);

        return Math.max(left,Math.max(current,right));
    }

    private static int getIndexOfMin(int[] h, int start, int end) {
        int minIndex = start;
        for (int i = start; i < end+1; i++) {
            if (h[i]<minIndex){
                minIndex = h[i];
            }
        }

        return minIndex;
    }
}
