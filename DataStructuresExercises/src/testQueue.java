import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class testQueue {
    private static ArrayList<String> queue = new ArrayList<>();
    private static HashMap<String, Integer> names = new HashMap<String, Integer>();
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();

        while (!input.equals("End")) {
            String[] commandParameters = input.split(" ");

            switch (commandParameters[0]) {
                case "Append":
                    String nameToAppend = commandParameters[1];
                    queue.add(nameToAppend);
                    if (!names.containsKey(nameToAppend)) {
                        names.put(nameToAppend, 0);
                    }

                    int temp = names.get(nameToAppend) + 1;
                    names.put(nameToAppend, temp);
                    result.append("OK\n");
                    break;
                case "Insert":
                    int positionToInsert = Integer.parseInt(commandParameters[1]);
                    String nameToInsert = commandParameters[2];

                    if (positionToInsert >= 0 && positionToInsert <= queue.size()) {
                        queue.add(positionToInsert, nameToInsert);
                        if (!names.containsKey(nameToInsert)) {
                            names.put(nameToInsert, 0);
                        }

                        int tempInsert = names.get(nameToInsert) + 1;
                        names.put(nameToInsert, tempInsert);
                        result.append("OK\n");
                    } else {
                        result.append("Error\n");
                    }
                    break;

                case "Find":
                    String nameToFind = commandParameters[1];

                    if (names.containsKey(nameToFind)) {
                        result.append(names.get(nameToFind).toString());
                    } else {
                        result.append("0");
                    }
                    result.append("\n");
                    break;

                case "Serve":
                    int numberOFPeople = Integer.parseInt(commandParameters[1]);

                    if (numberOFPeople <= queue.size()) {
                        StringBuilder sb = new StringBuilder();
                        String personName = "";
                        int i = 0;
                        for (int j = 0; j < numberOFPeople; j++) {
                            personName = queue.get(j);

                            sb.append(String.format("%s ", personName));

                            int tempName = names.get(personName) - 1;
                            names.put(personName, tempName);

                        }
                        for (int j = 0; j < numberOFPeople; j++) {
                            queue.remove(0);
                        }
                        sb.setLength(sb.length()-1);
                        result.append(sb.toString());

                    } else {
                        result.append("Error");
                    }
                    result.append("\n");
                    break;
            }
            input = in.readLine();
        }
        System.out.println(result.toString());
    }
}
