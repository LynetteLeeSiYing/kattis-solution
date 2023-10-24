import java.util.*;
import java.io.*;
public class candydivision {
    public static void main (String [] args) throws IOException {
        FastScanner reader = new FastScanner();
        PrintWriter pr = new PrintWriter(System.out);
        TreeSet<Long> t = new TreeSet<>();
        long n = reader.nextLong();
        for(long i = 0; i < Math.sqrt(n); i++) {
            if(n % (i + 1) == 0) {
                t.add(i);
                t.add(n / (i + 1) - 1);
            }
        }
        Iterator<Long> iter = t.iterator();
        while(iter.hasNext()) {
            pr.print(iter.next() + " ");
        }
        pr.close();

    }
}

