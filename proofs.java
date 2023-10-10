import java.io.*;
import java.util.*;
public class proofs {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int num = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        boolean wrong = false;
        for(int i = 1; i <= num; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            String assum;
            while (!(assum = line.nextToken()).equals("->")) {
                if(!hs.contains(assum)) {
                    wrong = true;
                    break;
                }

            }
            if(wrong) {
                pr.println(i);
                break;
            }
            String conclusion = line.nextToken();
            hs.add(conclusion);

        }
        if(!wrong)
            pr.println("correct");
        pr.close();
    }

}
