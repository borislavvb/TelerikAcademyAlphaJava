package ExamDsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class thirdTask {

    private static  StringBuilder output = new StringBuilder();

    public static class Produt implements Comparable {
        private String name;
        private double price;
        private String type;

        public Produt(String name, double price, String type) {
            this.name = name;
            this.price = price;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public int compareTo(Object o) {
            Produt prod = (Produt) o;
            int result = Double.compare(this.price, prod.getPrice());
            if (result == 0) {
                result = this.getName().compareTo(prod.getName());
            }
            return result;
        }

        public String toString() {

            return String.format("%s(%s)", this.getName(), this.getPrice());
        }
    }

    public static void main(String[] args) throws IOException {
        TreeMap<String,Integer> sd = new TreeMap<>();



        HashMap<String, TreeSet<Produt>> typeToProduct = new HashMap<>();
        TreeSet<Produt> productByPrice = new TreeSet<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] commandArgs=bf.readLine().split(" ");
        while (commandArgs[0]=="end"){
            commandArgs = bf.readLine().split(" ");
            switch (commandArgs[0]) {
                case "add":
                    String name = commandArgs[1];
                    double price = Double.parseDouble(commandArgs[2]);
                    String type = commandArgs[3];

                    Produt product = new Produt(name, price, type);
                    if (!typeToProduct.containsKey(type)) {
                        typeToProduct.put(type, new TreeSet<>());
                    }
                    if (typeToProduct.get(type).contains(product)) {
                        output.append(String.format("Error: Product %s already exists", name));
                        output.append("\n");

                    } else {
                        typeToProduct.get(type).add(product);
                        productByPrice.add(product);
                        output.append(String.format("Ok: Product %s added successfully\n", name));

                    }

                case "filter":
                    if (commandArgs.length == 4) {
                        String filterType = commandArgs[3];
                        if (typeToProduct.containsKey(filterType)) {
                            output.append("Ok: ");
                            output.append(typeToProduct.get(filterType).stream()
                                    .limit(10)
                                    .map(x -> x.toString())
                                    .collect(Collectors.joining(", ")));
                            output.append("\n ");
                        } else {
                            output.append(String.format("Error: Type %s does not exists\n", filterType));
                        }
                    } else if (commandArgs.length == 7) {
                        double min = Double.parseDouble(commandArgs[4]);
                        double max = Double.parseDouble(commandArgs[6]);
                        output.append("Ok: ");
                        output.append(productByPrice.stream()
                                .filter(x -> x.getPrice() >= min && x.getPrice() <= max)
                                .limit(10)
                                .map(x->x.toString())
                                .collect(Collectors.joining(", ")));
                        output.append("\n ");

                    }else if (commandArgs.length==5){
                        String way = commandArgs[3];
                        switch (way){
                            case "from":
                                double priceFrom = Double.parseDouble(commandArgs[4]);
                                output.append("Ok: ");
                                output.append(productByPrice.stream()
                                        .filter(x->x.getPrice()>=priceFrom)
                                        .limit(10)
                                        .map(x->x.toString())
                                        .collect(Collectors.joining(", ")));
                                output.append("\n ");
                                break;
                            case "to":
                                double priceTo = Double.parseDouble(commandArgs[4]);
                                output.append("Ok: ");
                                output.append(productByPrice.stream()
                                        .filter(x->x.getPrice()<=priceTo)
                                        .limit(10)
                                        .map(x->x.toString())
                                        .collect(Collectors.joining(", ")));
                                output.append("\n ");
                                break;
                        }
                    }
                    break;
            }
        }

        System.out.println(output);
    }
}
