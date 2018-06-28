package ExamDsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SupermarketQueue {
    private static List<String> queue = new ArrayList<>();
    private static HashMap<String, Integer> names = new HashMap<String, Integer>();
    private static StringBuilder result = new StringBuilder();
    private static final String SUCCESS = "OK\n";
    private static final String ERROR = "Error\n";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();

        while (!input.equals("End")) {
            String[] commandParameters = input.split(" ");

            switch (commandParameters[0]) {
                case "Append":
                    handleAppend(commandParameters);
                    break;
                case "Insert":
                    handleInsert(commandParameters);
                    break;

                case "Find":
                    handleFind(commandParameters);

                    break;

                case "Serve":
                    handleServe(commandParameters);
                    break;
            }
            input = in.readLine();
        }
        System.out.println(result.toString());
    }

    private static void handleFind(String[] commandParameters) {
        String nameToFind = commandParameters[1];

        if (names.containsKey(nameToFind)) {
            result.append(names.get(nameToFind).toString());
        } else {
            result.append("0");
        }
        result.append("\n");
    }

    private static void handleServe(String[] commandParameters) {
        int numberOFPeople = Integer.parseInt(commandParameters[1]);

        if (numberOFPeople <= queue.size()) {
            StringBuilder sb = new StringBuilder();

            int i = 0;
            while (i<numberOFPeople){
                sb.append(String.format("%s ", queue.get(0)));
                names.put(queue.get(0), names.get(queue.get(0)) - 1);
                queue.remove(0);
                i++;
            }

            sb.setLength(sb.length()-1);
            result.append(sb.toString());

        } else {
            result.append("Error");
        }
        result.append("\n");
    }

    private static void handleInsert(String[] commandParameters) {
        int positionToInsert = Integer.parseInt(commandParameters[1]);
        String nameToInsert = commandParameters[2];

        if (positionToInsert >= 0 && positionToInsert <= queue.size()) {
            queue.add(positionToInsert, nameToInsert);
            if (!names.containsKey(nameToInsert)) {
                names.put(nameToInsert, 0);
            }

            names.put(nameToInsert, names.get(nameToInsert) + 1);
            result.append(SUCCESS);
        } else {
            result.append(ERROR);
        }
    }

    private static void handleAppend(String[] commandParameters) {

        String nameToAppend = commandParameters[1];
        queue.add(nameToAppend);
        if (!names.containsKey(nameToAppend)) {
            names.put(nameToAppend, 0);
        }

        names.put(nameToAppend,names.get(nameToAppend) + 1);
        result.append(SUCCESS);

    }


}
