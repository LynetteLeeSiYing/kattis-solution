import java.io.*;
import java.util.*;

public class conformity {
    public static void main(String[] args) throws IOException {
        FastScanner reader = new FastScanner();
        PrintWriter pr = new PrintWriter(System.out);
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>(); //sorted combination as the key
        int n = reader.nextInt();
        int max = 0;
        while(n-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            int t = 5;
            while(t-- > 0) {
                int num = reader.nextInt();
                arr.add(num);
            }
            Collections.sort(arr);
            if(map.containsKey(arr)) {
                int f = map.get(arr);
                map.put(arr, f + 1);
                max = Math.max(max, f + 1);
            } else {
                map.put(arr, 1);
                max = Math.max(max, 1);
            }
        }
        int count = 0;
        for(int i : map.values()) {
            if(i == max) {
                count++;
            }
        }
        pr.println(count * max);
        pr.close();
    }
}
//class FastScanner {
//    BufferedReader br = new BufferedReader(
//            new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer("");
//
//    String next() {
//        while (!st.hasMoreTokens())
//            try {
//                st = new StringTokenizer(br.readLine());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        return st.nextToken();
//    }
//
//    int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    int[] readArray(int n) {
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++)
//            a[i] = nextInt();
//        return a;
//    }
//
//    long nextLong() {
//        return Long.parseLong(next());
//    }
//}
