import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class UnitsOfWork2 {
    private static HashMap<String, Unit> unitsMap = new HashMap<>();
    private static HashMap<String, TreeSet<Unit>> orderedUnitsByType = new HashMap<>();
    private static TreeSet<Unit> orderedUnits = new TreeSet<>();
    private static StringBuilder result = new StringBuilder();

    public static void units() {
        Scanner in = new Scanner(System.in);

        while (true) {
            String nextLine = in.nextLine();
            String[] command = nextLine.split(" ");

            switch (command[0]) {
                case "add":
                    addUnit(command);
                    break;
                case "remove":
                    removeUnit(command);
                    break;
                case "find":
                    findUnit(command);
                    break;
                case "power":
                    powerUnit(command);
                    break;
                case "end":
                    System.out.println(result);
                    return;
            }
        }
    }

    private static void addUnit(String[] arguments) {
        if (unitsMap.containsKey(arguments[1])) {
            result.append(String.format("FAIL: %s already exists!\n", arguments[1]));
        } else {
            Unit newUnit = new Unit(arguments[1], arguments[2], Integer.parseInt(arguments[3]));
            unitsMap.put(arguments[1], newUnit);
            if (!orderedUnitsByType.containsKey(arguments[2])) {
                orderedUnitsByType.put(arguments[2], new TreeSet<>());
            }
            TreeSet<Unit> orderedUnitsBucket = orderedUnitsByType.get(arguments[2]);
            orderedUnitsBucket.add(newUnit);
            orderedUnits.add(newUnit);
            result.append(String.format("SUCCESS: %s added!\n", arguments[1]));
        }
    }

    private static void removeUnit(String[] arguments) {
        if (!unitsMap.containsKey(arguments[1])) {
            result.append(String.format("FAIL: %s could not be found!\n", arguments[1]));
        } else {
            Unit unit = unitsMap.get(arguments[1]);
            unitsMap.remove(arguments[1]);
            orderedUnitsByType.get(unit.type).remove(unit);
            orderedUnits.remove(unit);
            result.append(String.format("SUCCESS: %s removed!\n", arguments[1]));
        }
    }

    private static void findUnit(String[] arguments) {
        result.append(String.format("RESULT: "));
        if (orderedUnitsByType.containsKey(arguments[1])) {
            result.append(orderedUnitsByType.get(arguments[1]).stream()
                    .limit(10)
                    .map(x -> x.toString())
                    .collect(Collectors.joining(", ")));
        }
        result.append("\n");
    }

    private static void powerUnit(String[] arguments) {
        result.append(String.format("RESULT: "));
        result.append(orderedUnits.stream()
                .limit(Integer.parseInt(arguments[1]))
                .map(x -> x.toString())
                .collect(Collectors.joining(", ")));

        result.append("\n");
    }

    static class Unit implements Comparable {
        String name, type;
        int attack;

        Unit(String name, String type, int attack) {
            this.name = name;
            this.type = type;
            this.attack = attack;
        }

        @Override
        public String toString() {
            return String.format("%s[%s](%s)", name, type, attack);
        }


        @Override
        public int compareTo(Object o) {
            Unit unit = (Unit) o;
            int attackCompare = Integer.compare(this.attack, unit.attack);
            if (attackCompare != 0) {
                return -attackCompare;
            }
            return this.name.compareTo(unit.name);
        }
    }

}
