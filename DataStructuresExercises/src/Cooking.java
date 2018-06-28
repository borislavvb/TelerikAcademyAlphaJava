import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    private static StringBuilder finalResult = new StringBuilder();
    private static HashMap<String,Product> allProductsByName = new HashMap<>();
    private static HashMap<String,SortedSet<Product>> allProductsByTypeSorted = new HashMap<>();
    private static SortedSet<Product> allProductsSorted = new TreeSet<Product>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] commands = bf.readLine().split(" ");

        do {
            if (commands[0].equals("add")){
                addProduct(commands);
            }else if (commands.equals("filter")){
                if (commands[2].equals("type")){
                    FilterByType(commands);
                }else if (commands[2].equals("price")){
                    FilterByPrice(commands);
                }
            }
        }while (commands[0].equals("end"));

        System.out.println(finalResult);

    }

    public static class Product{

        private String name;
        private int price;
        private String type;

        public Product(String name, int price, String type){
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

        public int getPrice() {
            return price;
        }

        public int compareTo(Product o) {
            int resultToReturn = Integer.compare(this.price,o.getPrice());
            if (resultToReturn == 0) {
                resultToReturn = this.name.compareTo(o.name);
            }
            if (resultToReturn==0){
                resultToReturn=this.type.compareTo(o.getType());
            }

            return resultToReturn;
        }
        @Override
        public String toString(){
            return String.format("{0}({1})",this.name,this.price);
        }
    }

    private static void FilterByPrice(String[] commands) {
        if (commands.length==7){
            int minPrice = Integer.parseInt(commands[4]);
            int maxPrice =  Integer.parseInt(commands[6]);

            Set<Product> filteredProducts = new HashSet<>();
            filteredProducts = allProductsSorted.stream()
                    .limit(10)
                    .filter(x->x.getPrice()>=minPrice&&x.getPrice()<=maxPrice)
                    .collect(Collectors.toSet());

            if (filteredProducts.size()==0){
                finalResult.append("Ok: ");
            }else{
                finalResult.append("Ok: ");
                for(Product i: filteredProducts){
                    finalResult.append(String.format("%s, ",i.getName()));
                }
            }
        }else if (commands.length==5){
            if (commands[3].equals("from")) {
                int startPrice = Integer.parseInt(commands[4]);
                Set<Product> filteredProducts = new HashSet<>();
                filteredProducts = allProductsSorted.stream()
                        .limit(10)
                        .filter(x->x.getPrice()>=startPrice)
                        .collect(Collectors.toSet());

                if (filteredProducts.size() == 0){
                    finalResult.append("Ok: ");
                }else {
                    finalResult.append("Ok: ");
                    for (Product i: filteredProducts){
                        finalResult.append(String.format("%s, ",i.getName()));
                    }
                }
            }else if (commands[3].equals("to")){
                int maxPrice = Integer.parseInt(commands[4]);
                Set<Product> filteredProduct = new HashSet<>();
                filteredProduct = allProductsSorted.stream()
                        .limit(10)
                        .filter(x->x.getPrice()<=maxPrice)
                        .collect(Collectors.toSet());

                if (filteredProduct.size()==0){
                    finalResult.append("Ok: ");
                }else {
                    finalResult.append("Ok: ");
                    for (Product i:filteredProduct){
                        finalResult.append(String.format("%s, ",i.toString()));
                    }
                }
            }
        }
    }

    private static void FilterByType(String[] commands) {
        String productType = commands[3];

        if (!allProductsByTypeSorted.containsKey(productType)){
            finalResult.append(String.format("Error: Type %s does not exists", productType));
        }else {
            finalResult.append("Ok: ");
            for (Product i: allProductsByTypeSorted.get(productType)){
                finalResult.append(String.format("%s, ",i.toString()));
            }
        }

    }

    private static void addProduct(String[] commands) {
        String newProductName = commands[1];
        String newProductType = commands[3];
        int newProductPrice = Integer.parseInt(commands[2]);

        if (!allProductsByName.containsKey(newProductName)){
            Product newProduct = new Product(newProductName,newProductPrice,newProductType);
            allProductsByName.put(newProductName,newProduct);
            finalResult.append(String.format("Ok: Product %s added successfully",newProductName));

            allProductsSorted.add(newProduct);

            if (!allProductsByTypeSorted.containsKey(newProductType)){
                allProductsByTypeSorted.put(newProductType,new TreeSet<>());
                allProductsByTypeSorted.get(newProductType).add(newProduct);
            }else {
                if (allProductsByTypeSorted.get(newProductType).size()<10){
                    allProductsByTypeSorted.get(newProductType).add(newProduct);
                }else {
                    Product lastByType = allProductsByTypeSorted.get(newProductType).last();

                    if (lastByType.compareTo(newProduct)>0){
                        allProductsByTypeSorted.get(newProductType).add(newProduct);
                        allProductsByTypeSorted.get(newProductType).remove(lastByType);
                    }
                }
            }
        }else {
            finalResult.append(String.format("Error: Product %s already exists",newProductName));
        }
    }
}
