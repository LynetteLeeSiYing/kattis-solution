import java.util.*;
import java.io.*;

public class knigsoftheforest {
    public static void main(String[] args) throws IOException {
        FastScanner reader = new FastScanner();
        PrintWriter pr = new PrintWriter(System.out);
        int k = reader.nextInt();
        int n = reader.nextInt();
        int y = reader.nextInt();
        int p = reader.nextInt();
        PriorityQueue<Integer> toSort = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Moose> future = new PriorityQueue<>();
        for (int i = 1; i <= k + n - 2; i++) {
            int year = reader.nextInt();
            int s = reader.nextInt();
            if (year == 2011) { //put to arr
                toSort.add(s);
            } else { // store in priority queue
                Moose m = new Moose(year, s);
                future.add(m);
            }
        }
        if (y == 2011) toSort.add(p);
        else future.add(new Moose(y, p));
        int year = 2011;
        while (!future.isEmpty()) {
            int max = toSort.peek();
            if (max == p) {
                pr.println(year);
                pr.close();
                break;
            } else { //remove the king, add the other year
                toSort.poll();
                Moose m = future.poll();
                year = m.year;
                toSort.add(m.strength);
            }

        }
        // cant determine
        if(!toSort.isEmpty() && toSort.peek() == p) pr.println(year);
        else pr.println("unknown");
        pr.close();
    }
}

class Moose implements Comparable<Moose> {
    int year;
    int strength;

    public Moose(int y, int p) {
        year = y;
        strength = p;
    }

    @Override
    public int compareTo(Moose o) {
        return this.year - o.year;
    }
}

