import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class CokiSkokiBest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[] builds=parsing(br.readLine().split(" "));
        int[] jumpsMax=new int[builds.length];
        ArrayDeque<Integer> indexBuilding = new ArrayDeque<>();


        for (int i = builds.length-1;i>=0;i--)
        {
            while(!indexBuilding.isEmpty()&&builds[indexBuilding.peek()]<=builds[i])
            {
                int index= indexBuilding.pop();
                jumpsMax[index]=indexBuilding.size();
            }
            indexBuilding.push(i);
        }

        while(!indexBuilding.isEmpty()){
            int index= indexBuilding.pop();
            jumpsMax[index]=indexBuilding.size();
        }
        printSolution(jumpsMax);
    }

    private static int[] parsing (String[] a){

        int[] result = new int[a.length];

        for(int i =0;i<a.length;i++)
        {
            result[i]=Integer.parseInt(a[i]);
        }
        return result;
    }

    private static void printSolution (int[] a){
        String[] result = new String[a.length];
        for(int i=0;i<result.length;i++){
            result[i]=String.valueOf(a[i]);
        }
        Arrays.sort(a);
        int max = a[a.length-1];
        System.out.println(max);
        System.out.println(String.join(" ",result));
    }
}
