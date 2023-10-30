import java.util.*;
import java.io.*;

public class quickscope {
    public static void f() {

    }
    public static void main(String[] args) throws IOException {
        FastScanner reader = new FastScanner();
        PrintWriter pr = new PrintWriter(System.out);
        int N = reader.nextInt();
        HashMap<String, Stack<block>> map = new HashMap<>(); // a stack to store the Declaration, the closest one to be on top
        Stack<HashSet<String>> layer = new Stack<>(); //stack to store the variables in a particular layer, to easy remove once exit block
        layer.add(new HashSet<>());
        int id = 1;
        while(N-- > 0) {
            String cmd = reader.next();
            if(cmd.equals("TYPEOF")) {
                String v = reader.next();
                if(map.containsKey(v)) {
                    Stack<block> s = map.get(v);
                    if(s.isEmpty()) {
                        pr.println("UNDECLARED");
                    } else {
                        pr.println(s.peek().declare);
                    }
                } else {
                    pr.println("UNDECLARED");
                }
            } else if(cmd.equals("DECLARE")){
                String v = reader.next();
                String type = reader.next();
                block b = new block(id, type);
                if(map.containsKey(v)) {
                    Stack<block> s = map.get(v);
                    if(s.isEmpty()) {
                        s.add(b);
                        layer.peek().add(v);
                    } else {
                        if(s.peek().id == id) {pr.println("MULTIPLE DECLARATION"); break;}
                        else {s.add(b); layer.peek().add(v);} //else the other declarations made outside the block
                    }
                } else {
                    map.put(v, new Stack<>());
                    map.get(v).add(b);
                    layer.peek().add(v);
                }
            } else if(cmd.equals("{")) {
                id++;
                layer.add(new HashSet<>());

            } else {
                id--;
                Iterator<String> iter = layer.peek().iterator();
                //remove every declaration made within the block
                while(iter.hasNext()) {
                    map.get(iter.next()).pop();
                }
                layer.pop();
            }
        }
        pr.close();
    }
}
class block {
    int id;
    String declare;
    public block(int i , String s) {
        id = i;
        declare = s;
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
