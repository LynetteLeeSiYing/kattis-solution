import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.PriorityQueue;

public class jugglingpatterns {

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        String eline;
        while((eline = br.readLine())!=null && !eline.isEmpty()) {
            String[] str = eline.split("");
            int [] line = new int[str.length];
            int sum = 0;
            for(int i = 0; i < line.length; i++) {
                line[i] =  Integer.parseInt(str[i]);
                sum += line[i];
            }

            if(sum % str.length != 0) {
                pr.println(eline + ": invalid # of balls");
                continue;
            }
            int balls = sum / str.length;
            boolean wrong = false;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0; i < str.length * 100; i++) {
                if (line[i % line.length] != 0) {

                    if (balls > 0 && (pq.isEmpty() || pq.peek() > i)) {
                        pq.add(line[i % line.length] + i);
                        balls--;
                        continue;
                    }
                    if (!pq.isEmpty()) {
                        if (pq.peek() == i) {
                            pq.poll();
                            wrong = !pq.isEmpty() && pq.peek() == i;
                        }else{
                            wrong = true;
                        }
                    }
                    pq.add(line[i % line.length] + i);
                }
            }
            if(wrong) {
                pr.println(eline + ": invalid pattern");
            } else {
                pr.println(eline + ": valid with " + sum/line.length + " balls");
            }

        }
        pr.close();

    }
}
