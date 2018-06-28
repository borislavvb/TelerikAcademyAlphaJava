import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String,Integer> add = new HashMap<>();
        add.put("gosho",0);
        add.put("gosho",9);


        System.out.println(add.get("gosho"));
    }
}
