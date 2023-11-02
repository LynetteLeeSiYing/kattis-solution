import java.util.*;
import java.io.*;

public class awkwardparty {
    public static void main(String[] args) throws IOException {
        FastScanner reader = new FastScanner();
        PrintWriter pr = new PrintWriter(System.out);
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Seat> map = new HashMap<>(); // store the num(of language) 
        int n = reader.nextInt();
        int min = n;
        while(n-- > 0) {
            int num = reader.nextInt();
            arr.add(num);
        }

        for(int i = 0; i < arr.size(); i++) {
            int finalI = i;
            map.compute(arr.get(i), (key, value) -> value == null
                    ? new Seat(finalI, arr.size())
                    : new Seat(finalI, Math.min(value.level, finalI - value.pos))); //remember the current pos, store the min awkward level
        }

        for(Seat s : map.values()) {
            if (s.level < min) {
                min = s.level;
            }
        }
        pr.println(min);
        pr.close();
    }
}
class Seat {
    int pos; //store the nearest position
    int level;
    public Seat(int i , int n) {
        pos = i;
        level = n;
    }
}

