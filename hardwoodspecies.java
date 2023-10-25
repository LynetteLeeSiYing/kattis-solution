import java.io.*;
import java.util.*;
public class hardwoodspecies {
    public static void main(String[] args) throws IOException {
        TreeSet<String> map = new TreeSet<>();
        HashMap<String, Integer> hm = new HashMap<>(); //need to update the value, so hashmap better, can serach in O(1)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        String name;
        int size =0;
        while((name = br.readLine()) != null && !name.isEmpty()) {
            size++;
            if(hm.containsKey(name)) {
                hm.put(name, hm.get(name) + 1);
            } else {
                hm.put(name, 1);
                map.add(name);
            }
        }
        Iterator<String> iter = map.iterator();
        while(iter.hasNext()) {
            String tree = iter.next();
            int num = hm.get(tree);
            double percent = (double) num / size * 100;
            pr.printf("%s %.6f\n", tree, percent);
           //pr.println(tree + " " + String.format("%6f", percent));
        }
        pr.close();
    }
}
