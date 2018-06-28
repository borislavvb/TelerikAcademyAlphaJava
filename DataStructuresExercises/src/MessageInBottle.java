import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MessageInBottle {
    private static int counter = 0;
    private static ArrayList<ArrayList<Character>> result;
    private static ArrayList<Character> letter;
    private static ArrayList<String> code;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String message = bf.readLine();
        String codeStr = bf.readLine();
        result = new ArrayList<>();
        letter = new ArrayList<>();
        code = new ArrayList<>();
        handleCodeStr(codeStr);
        result.add(new ArrayList<>());
        //StringBuilder sb = new StringBuilder();
        readRealMessage(message);
        result.remove(result.size()-1);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j));
            }
            System.out.println();
        }

    }

    private static void readRealMessage(String message) {

        for (int i = 0; i < code.size(); i++) {
            if (message.startsWith(code.get(i))){
                result.get(counter).add(letter.get(i));
                String newMessage = message.substring(code.get(i).length());
                if (newMessage.equals("")){
                    result.add(new ArrayList<>());
                    counter++;
                    return;
                }
                readRealMessage(newMessage);
            }
        }

    }

    private static void handleCodeStr(String codeStr) {
        int start=1;
        int end;
        letter.add(codeStr.charAt(0));
        for (int i = 1; i < codeStr.length(); i++) {
            if (Character.isAlphabetic(codeStr.charAt(i))){
                letter.add(codeStr.charAt(i));
                end=i;
                code.add(codeStr.substring(start,end));
                start=end+1;
            }
        }
        code.add(codeStr.substring(start));
    }
}
