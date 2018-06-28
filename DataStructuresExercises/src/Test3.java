import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//public class Test3 {
 //   public static void main(String[] args) throws IOException {
 //     BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 //     int n = Integer.parseInt(in.readLine());
 //     HashMap<String,HashMap<String,Tree<String>>> allPeople = new HashMap<>();
 //     StringBuilder sb = new StringBuilder();
 //     for (int i = 0; i < n; i++) {
 //         String[] line = in.readLine().split(" ");
 //         String personX= line[0];
 //         String personY = line[1];
 //         String subjectZ = line[2];
 //         if (!allPeople.containsKey(subjectZ)){
 //             Tree<String> parent = new Tree<>(personY);
 //             Tree<String> child = new Tree<>(personX);
 //             parent.addChild(child);
 //             allPeople.put(subjectZ,new HashMap<>());
 //             //allPeople.get(subjectZ).put(child,new TreeSet<String>());
 //             //allPeople.get(subjectZ).put(parent,new TreeSet<>());
 //         }else {
 //             Tree<String> child = null;
 //             if (allPeople.get(subjectZ).containsKey(personX)){
 //                 child = allPeople.get(subjectZ).get(personX);
 //             }else {
 //                 child = new Tree<String>(personX);
 //                 allPeople.get(subjectZ).get(personX).addChild(child);
 //             }
 //             Tree<String> parent = null;
 //             if (allPeople.get(subjectZ).containsKey(personY)){
 //                 parent = allPeople.get(subjectZ).get(personY);
 //             }else {
 //                 parent = new Tree<String>(personY);
 //                 allPeople.get(subjectZ).get(personY).addChild(parent);
 //             }
 //             parent.addChild(child);
 //         }
 //     }
 //     int m = Integer.parseInt(in.readLine());
//
//
 //   for (int i = 0; i < m; i++) {
 //       String[] line = in.readLine().split(" ");
 //       String depending = line[0];
 //       String on = line[1];
//
 //   Tree<String> dependingNode = allPeople.get(on).get(depending);
 //   String parent = depending.getParents;
 //           String parent = dependingNode.Parent;
 //           Queue<String> deps = new LinkedList<>();
 //           deps.AddFirst(dependingNode.GetValue());
//
 //           while (parent != null)
 //           {
 //               deps.AddFirst(parent.GetValue());
 //               parent = parent.Parent;
 //           }
//
 //           sb.AppendLine(string.Join(", ", deps));
 //       }
//
 //       var res = sb.ToString().TrimEnd();
 //       Console.WriteLine(res);
 //       }
//
 //   }
//
 //     class Tree<T> {
 //       private T value;
 //       private ArrayList<Tree<T>> nodes;
 //       public Tree<T> parents;
//
 //       public Tree(T value){
 //           this.value = value;
 //           nodes = new ArrayList<>();
 //       }
//
 //       public Tree<T> getParents() {
 //           return parents;
 //       }
//
 //       public ArrayList<Tree<T>> getNodes() {
 //           return nodes;
 //       }
//
 //       public T getValue() {
 //           return value;
 //       }
//
 //       public void addChild(T value){
 //           nodes.add(new Tree<>(value));
 //       }
//
 //       public void addChild(Tree<T> value){
 //           nodes.add(value);
 //           value.parents = this;
 //       }
//
 //       @Override
 //       public String toString() {
 //           return this.value.toString();
 //       }
 //   }

