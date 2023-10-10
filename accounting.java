import java.io.*;
import java.util.*;
public class accounting {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int Q = Integer.parseInt(str.nextToken());
        // hashmap of size N
        HashMap<Integer, Integer> hm = new HashMap<>();
        int wealth = 0; // default wealth
        while(Q-- > 0) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            String word = line.nextToken();
            int i = Integer.parseInt(line.nextToken());
            if(word.equals("SET")) {
                int x = Integer.parseInt(line.nextToken());
                hm.put(i, x);
            } else if (word.equals("PRINT")){
                int value = hm.getOrDefault(i, wealth);
                pr.println(value);
            } else {
                wealth = i;
                hm.clear();
            }
        }
        pr.close();

    }
}
