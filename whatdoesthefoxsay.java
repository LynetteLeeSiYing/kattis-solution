import java.util.*;
import java.io.*;

public class whatdoesthefoxsay {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pr = new PrintWriter(System.out);
        int num = sc.nextInt();
        sc.nextLine();
        while(num-- > 0) {
            StringTokenizer str = new StringTokenizer(sc.nextLine());
            HashSet<String> known = new HashSet<>();
            String line;
            while(!((line = sc.nextLine()).equals("what does the fox say?"))) {
                String[] s = line.split(" goes ");
                String sound = s[1];
                known.add(sound);
            }
            String each;
            while(str.hasMoreTokens()) {
                if(!known.contains(each = str.nextToken())) {
                    System.out.print(each + " ");

                }
            }
            System.out.println();

        }

    }
}
