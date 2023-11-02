import java.util.*;
import java.io.*;

public class compoundwords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        TreeSet<String> res = new TreeSet<>();
        String word;
        ArrayList<String> words = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer str = new StringTokenizer(line);
            while (str.hasMoreTokens()) {
                words.add(str.nextToken());
            }
        }
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (i != j) {
                    res.add(words.get(i) + words.get(j));
                }
            }
        }
        Iterator<String> iter = res.iterator();
        while (iter.hasNext()) {
            pr.println(iter.next());
        }
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
