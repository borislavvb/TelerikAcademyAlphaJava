import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Cooking2 {
    private  static HashSet<String> currentSloganWords;
    private static String currentSlogan;
    private static StringBuilder currentlyFormedSlogan = new StringBuilder();
    private static StringBuilder getCurrentlyFormedSloganWithSpaces = new StringBuilder();
    private static StringBuilder foundedSlogan = new StringBuilder();
    private static boolean mustBreak;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            String[] str = bf.readLine().split(" " );
            currentSloganWords = new HashSet<String>();
            for (int j = 0; j < str.length; j++) {
                currentSloganWords.add(str[i]);
            }

            FindSloganRecursive(mustBreak,0);
            if (mustBreak){
                System.out.println(getCurrentlyFormedSloganWithSpaces.toString().trim());
                mustBreak=false;
            }else {
                System.out.println("NOT VALID");
            }
            currentlyFormedSlogan.setLength(0);
            getCurrentlyFormedSloganWithSpaces.setLength(0);
        }
    }

    private static void FindSloganRecursive(boolean mustBreak, int currentPosition) {
        for (int j = 1; j < currentSlogan.length() ; j++) {
            if (currentPosition+j > currentSlogan.length()){
                if (currentPosition==currentSlogan.length()){
                    if (currentlyFormedSlogan.toString().equals(currentSlogan)){
                        foundedSlogan.append(currentlyFormedSlogan.toString());
                        mustBreak = true;
                        return;
                    }
                }if (currentlyFormedSlogan.length()!=0){
                    int tempValue = currentPosition >= currentlyFormedSlogan.length()?currentlyFormedSlogan.length()-1:currentPosition;
                    currentlyFormedSlogan = currentlyFormedSlogan.delete(tempValue,currentlyFormedSlogan.length()-tempValue);
                    getCurrentlyFormedSloganWithSpaces = getCurrentlyFormedSloganWithSpaces.delete(tempValue,currentlyFormedSlogan.length()-tempValue+1);

                }
                return;
            }
            if (!currentSloganWords.contains(currentSlogan.substring(currentPosition,j))){
                continue;
            }
            currentlyFormedSlogan.append(currentSlogan.substring(currentPosition,j)+ " ");
            getCurrentlyFormedSloganWithSpaces.append(currentSlogan.substring(currentPosition,j)+" ");
            FindSloganRecursive(mustBreak,currentPosition+j);
            if (mustBreak){
                return;
            }
        }
    }
}
