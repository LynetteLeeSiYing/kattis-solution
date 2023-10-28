import java.util.*;
import java.io.*;

public class nicknames {
    public static void main(String[] args) throws IOException {
        FastScanner reader = new FastScanner();
        PrintWriter pr = new PrintWriter(System.out);
        int A = reader.nextInt();
        HashMap<String, Integer> memo = new HashMap<>();
        while (A-- > 0) {
            String name = reader.next();
            int last = 1;
            while (last <= name.length()) {
                String key = name.substring(0, last); //store each combination since name.length<=10
                if (!memo.containsKey(key)) {
                    memo.put(key, 1);
                } else {
                    int num = memo.get(key);
                    memo.remove(key);
                    memo.put(key, num + 1);
                }
                last++;
            }

        }
        int B = reader.nextInt();
        while (B-- > 0) {
            String nick = reader.next();
            int count = 0;
            if (memo.containsKey(nick)) { //check if it's counted before
                count = memo.get(nick);
            }
            pr.println(count);
        }
        pr.close();
    }
}

class FastScanner {
    BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    String next() {
        while (!st.hasMoreTokens())
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    int[] readArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}


