import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CokiSkoki {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int max = 0;
        String[] str = bf.readLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            arr[i]=Integer.parseInt(str[i]);
        }
        int[] jumps = new int[n];
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int constant = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]>constant){
                    count++;
                    constant=arr[j];
                }
            }
            jumps[i]=count;
            if (count>max){
                max=count;
            }
            count=0;
        }
        System.out.println(max);
        Arrays.stream(jumps)
                .forEach(x-> System.out.printf("%d ",x));
    }

    public static class OnlineMarket2 {
        private static StringBuilder finalResult = new StringBuilder();
        private static HashMap<String,Product> allProductsByName = new HashMap<>();
        private static HashMap<String,TreeSet<Product>> allProductsByTypeSorted = new HashMap<>();
        private static TreeSet<Product> allProductsSorted = new TreeSet<Product>();

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));



            do {
                String[] commands = bf.readLine().split(" ");
                if (commands[0].equals("add")){
                    addProduct(commands);
                }else if (commands[0].equals("filter")){
                    if (commands[2].equals("type")){
                        FilterByType(commands);
                    }else if (commands[2].equals("price")){
                        FilterByPrice(commands);
                    }
                }else if (commands[0].equals("end")){
                    break;
                }
            }while (true);

            System.out.println(finalResult);

        }

        private static class Product implements Comparable{

            private String name;
            private double price;
            private String type;

            public Product(String name, double price, String type){
                this.name = name;
                this.price = price;
                this.type = type;
            }
            public String getName() {
                return name;
            }

            public String getType() {
                return type;
            }

            public double getPrice() {
                return price;
            }


            @Override
            public String toString(){
                    return String.format("%s(%s)", this.name, this.price);
            }

            @Override
            public int compareTo(Object o) {
                Product compare = (Product) o;
                int resultToReturn = Double.compare(this.price,compare.getPrice());
                if (resultToReturn == 0) {
                    resultToReturn = this.name.compareTo(compare.getName());
                }
                if (resultToReturn==0){
                    resultToReturn=this.type.compareTo(compare.getType());
                }

                return resultToReturn;
            }
        }

        private static void FilterByPrice(String[] commands) {
            if (commands.length==7){
                double minPrice = Double.parseDouble(commands[4]);
                double maxPrice =  Double.parseDouble(commands[6]);


                    finalResult.append("Ok: ");
                if (allProductsSorted.size()!=0){
                    finalResult.append(allProductsSorted.stream()
                            .filter(x->x.getPrice()>=minPrice&&x.getPrice()<=maxPrice)
                            .limit(10)
                            .map(Product::toString)
                            .collect(Collectors.joining(", ")));
                }
                finalResult.append("\n");
            }else if (commands.length==5){
                if (commands[3].equals("from")) {
                    double startPrice = Double.parseDouble(commands[4]);
                    finalResult.append("Ok: ");
                    if (allProductsSorted.size() != 0){
                        finalResult.append(allProductsSorted.stream()
                                .filter(x->x.getPrice()>=startPrice)
                                .limit(10)
                                .map(Product::toString)
                                .collect(Collectors.joining(", ")));
                    }
                    finalResult.append("\n");

                }else if (commands[3].equals("to")){
                    double maxPrice = Double.parseDouble(commands[4]);

                    if (allProductsSorted.size()==0){
                        finalResult.append("Ok: ");
                    }else {
                        finalResult.append("Ok: ");
                        finalResult.append(allProductsSorted.stream()
                                .filter(x->x.getPrice()<=maxPrice)
                                .limit(10)
                                .map(Product::toString)
                                .collect(Collectors.joining(", ")));
                    }
                    finalResult.append("\n");

                }
            }
        }

        private static void FilterByType(String[] commands) {
            String productType = commands[3];

            if (!allProductsByTypeSorted.containsKey(productType)){
                finalResult.append(String.format("Error: Type %s does not exists", productType));
            }else {
                finalResult.append("Ok: ");
                finalResult.append(allProductsByTypeSorted.get(productType)
                .stream()
                .limit(10)
                .map(x->x.toString())
                .collect(Collectors.joining(", ")));
            }
            finalResult.append("\n");

        }

        private static void addProduct(String[] commands) {
            String newProductName = commands[1];
            double newProductPrice = Double.parseDouble(commands[2]);
            String newProductType = commands[3];

            if (!allProductsByName.containsKey(newProductName)){
                Product newProduct = new Product(newProductName,newProductPrice,newProductType);
                allProductsByName.put(newProductName,newProduct);
                finalResult.append(String.format("Ok: Product %s added successfully",newProductName));

                allProductsSorted.add(newProduct);

                if (!allProductsByTypeSorted.containsKey(newProductType)){
                    allProductsByTypeSorted.put(newProductType,new TreeSet<>());
                    allProductsByTypeSorted.get(newProductType).add(newProduct);
                }else {

                        allProductsByTypeSorted.get(newProductType).add(newProduct);

                }
            }else {
                finalResult.append(String.format("Error: Product %s already exists",newProductName));
            }

            finalResult.append("\n");

        }
    }
}
