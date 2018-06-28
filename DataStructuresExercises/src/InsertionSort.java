import java.util.Arrays;

public class InsertionSort {
    static void sort(int[] arr){
        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j = i-1;

            while (j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j -= 1;
            }

            arr[j+1] = key;

        }
    }

    static void print(int[] arr){
        Arrays.stream(arr)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] arr = {2,4,5,9,5,8,3,11,133,20,19,28};
        sort(arr);
        print(arr);
    }

}
