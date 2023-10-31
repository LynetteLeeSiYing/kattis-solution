import java.util.*;
import java.io.*;

public class bungeebuilder {
    public static void main(String[] args) throws IOException {
        FastScanner reader = new FastScanner();
        PrintWriter pr = new PrintWriter(System.out);
        int n = reader.nextInt();
        int[] arr = new int[n];
        arr = reader.readArray(n);
        int best = 0;
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if(arr[i] > max) {
                best = Math.max(best, max - min); //build bridge
                max = arr[i];
                min = arr[i];
            } else {
                min = Math.min(min, arr[i]);
                best = Math.max(best, arr[i] - min); //build bridge
            }
        }
        pr.println(best);
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

