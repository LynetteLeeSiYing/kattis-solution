import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class annoyedcoworkers {
        public static void main (String [] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pr = new PrintWriter(System.out);
            String [] str = br.readLine().split(" ");
            int times = Integer.parseInt(str[0]);
            int line = Integer.parseInt(str[1]);
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            int max = 0;
            while(line -->0) {
                String [] ln = br.readLine().split(" ");
                int ini = Integer.parseInt(ln[0]);
                int c = Integer.parseInt(ln[1]);
                if(ini > max){
                    max = ini;
                }
                pq.add(new Pair(ini, c));

            }
            while(times --> 0) {
                if(!pq.isEmpty()) {
                    Pair p = pq.poll();
                    int change = p.ini + p.incre;
                    if(change > max){
                        max = change;
                    }
                    pq.add(new Pair(change, p.incre));
                }
            }
           pr.println(max);
           pr.close();
        }

}
 class Pair implements Comparable<Pair> {
    int ini;
    int incre;
    int total;
    public Pair(int a, int b) {
        this.ini = a;
        this.incre = b;
        this.total = a + b;
    }

     @Override
     public int compareTo(Pair o) {
        if(o.total == this.total){
            return this.incre - o.incre;
        }
        return this.total - o.total;
     }
 }
