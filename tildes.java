import java.io.*;
import java.util.*;

public class tildes {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter print = new PrintWriter(System.out);
        String [] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int line = Integer.parseInt(input[1]);
        UnionFind UF = new UnionFind(num);
        while(line-- > 0) {
            String [] str = br.readLine().split(" ");
            if(str[0].equals("t")) { //case t
                int a = Integer.parseInt(str[1]);
                int b = Integer.parseInt(str[2]);
                UF.union(a, b);
            } else {
                int size = UF.size(Integer.parseInt(str[1]));
                print.println(size);
            }
        }
        print.close();
    }
}
class UnionFind { // based 1
    private int[] parent;
    private int[] height;
    private int[] sizes;
    public UnionFind(int size){
        parent = new int[size + 1];
        height = new int[size + 1];
        sizes = new int[size + 1];
        for(int i = 1; i <= size; i++) {
            parent[i] = i;
            height[i] = 1;
            sizes[i] = 1;
        }
    }
    public int findParent(int x){
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]); // Path compression
        }
        return parent[x];
    }
    public void union(int a, int b) {
        int roota = findParent(a);
        int rootb = findParent(b);
        if(roota != rootb){
            if(height[roota] < height[rootb]) {
                parent[roota] = rootb;
                sizes[rootb] += sizes[roota];
            } else if(height[roota] > height[rootb]) {
                parent[rootb] = roota;
                sizes[roota] += sizes[rootb];
            } else {
                parent[rootb] = roota;
                height[roota]++;
                sizes[roota] += sizes[rootb];
            }
        }
    }
    public int size(int a){
        return sizes[findParent((a))];
    }
}
