import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class UnitsOfWork {

    private static HashMap<String, Unit> allUnits = new HashMap<>();
    private static HashMap<String, TreeSet<Unit>> orderedByType = new HashMap<>();
    private static TreeSet<Unit> orderedUnits = new TreeSet<>();
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner bf = new Scanner(System.in);

        while (true) {
            String[] command = bf.nextLine().split(" ");

            switch (command[0]) {
                case "add":
                    addUnit(command[1], command[2], command[3]);
                    break;
                case "remove":
                    removeUnit(command[1]);
                    break;
                case "find":
                    findUnits(command[1]);
                    break;
                case "power":
                    powerUnit(command[1]);
                    break;
                case "end":
                    System.out.println(result);
                    return;
            }
        }
    }

    private static void powerUnit(String power) {
            result.append(String.format("RESULT: "));
            result.append(orderedUnits.stream()
                    .limit(Integer.parseInt(power))
                    .map(Unit::toString)
                    .collect(Collectors.joining(", ")));

        result.append("\n");
    }

    private static void findUnits(String type) {
        result.append(String.format("RESULT: "));
        if (orderedByType.containsKey(type)) {
            result.append(orderedByType.get(type).stream()
                    .limit(10)
                    .map(Unit::toString)
                    .collect(Collectors.joining(", ")));
        }
        result.append("\n");
    }

    private static void removeUnit(String unitName) {
        if (!allUnits.containsKey(unitName)) {
            result.append(String.format("FAIL: %s could not be found!\n", unitName));
        } else {
            Unit unitToRemove = allUnits.get(unitName);
            allUnits.remove(unitName);
            orderedByType.get(unitToRemove.type).remove(unitToRemove);
            orderedUnits.remove(unitToRemove);
            result.append(String.format("SUCCESS: %s removed!\n", unitToRemove.name));
        }
    }

    private static void addUnit(String name, String type, String attack) {
        if (allUnits.containsKey(name)) {
            result.append(String.format("FAIL: %s already exists!\n", name));
        } else {
            Unit newUnit = new Unit(name, type, Integer.parseInt(attack));
            if (!orderedByType.containsKey(newUnit.type)) {
                orderedByType.put(newUnit.type, new TreeSet<>());
            }
            allUnits.put(name, newUnit);
            orderedByType.get(newUnit.type).add(newUnit);
            orderedUnits.add(newUnit);
            result.append(String.format("SUCCESS: %s added!\n", name));
        }
    }


    static class Unit implements Comparable {
        private String name;
        private String type;
        private int attack;

        public Unit(String name, String type, int attack) {
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
