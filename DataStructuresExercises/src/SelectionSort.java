import java.util.Arrays;
import java.util.HashSet;

public class SelectionSort {
    static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int min = arr[i];
            int index = i;

            for (int j = i; j < n; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }

            arr[index] = arr[i];
            arr[i] = min;
        }
    }

    static void print(int[] arr) {
        Arrays.stream(arr)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 3, 8, 66, 44, 77, 46, 23, 76};
        sort(arr);
        print(arr);
    }


}
