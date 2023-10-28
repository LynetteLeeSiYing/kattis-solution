import java.util.*;
import java.io.*;

public class stockprices {
    public static void main(String[] args) throws IOException {
        FastScanner reader = new FastScanner();
        PrintWriter pr = new PrintWriter(System.out);

        int tc = reader.nextInt();
        while (tc-- > 0) {
            TreeSet<Integer> sellTree = new TreeSet<>();
            TreeSet<Integer> buyTree = new TreeSet<>();
            HashMap<Integer, Integer> sellMap = new HashMap<>();
            HashMap<Integer, Integer> buyMap = new HashMap<>();
            int orders = reader.nextInt();
            String stockPrice = "-";
            while (orders-- > 0) {
                String type = reader.next();
                int num = reader.nextInt();
                reader.next();
                reader.next();
                int price = reader.nextInt();
                if (type.equals("buy")) {
                    if (sellTree.isEmpty()) {
                        //check if buyTree has the same price before
                        if (!buyTree.contains(price)) {
                            buyTree.add(price);
                            buyMap.put(price, num);
                        } else {
                            int addNum = buyMap.get(price);
                            buyMap.remove(price);
                            buyMap.put(price, addNum + num);
                        }
                        //check if there is sell price <= price
                    } else {
                        int askPrice = sellTree.first();
                        int iniNum = sellMap.get(askPrice);
                        while (askPrice <= price && num > 0) { //deal
                            if (num >= iniNum) {
                                sellTree.remove(askPrice);
                                sellMap.remove(askPrice);
                                num -= iniNum;
                            } else {
                                iniNum -= num;
                                num = 0;
                                sellMap.remove(askPrice);
                                sellMap.put(askPrice, iniNum); //update number of stocks
                            }
                            stockPrice = Integer.toString(askPrice);
                            if (sellTree.isEmpty()) {
                                break;
                            }
                            askPrice = sellTree.first();
                            iniNum = sellMap.get(askPrice);
                        }

                        if (num > 0) { //if buy order not fulfilled, add 'buy' to buyTree
                            if (buyMap.containsKey(price)) {
                                int preNum = buyMap.get(price);
                                buyMap.remove(price);
                                buyMap.put(price, preNum + num);
                            } else {
                                buyTree.add(price);
                                buyMap.put(price, num);
                            }
                        }
                    }
                } else {
                    if (buyTree.isEmpty()) {
                        //check if buyTree has the same price before
                        if (!sellTree.contains(price)) {
                            sellTree.add(price);
                            sellMap.put(price, num);
                        } else {
                            int addNum = sellMap.get(price);
                            sellMap.remove(price);
                            sellMap.put(price, addNum + num);
                        }

                    } else {
                        int bidPrice = buyTree.last();
                        int iniNum = buyMap.get(bidPrice);
                        while (bidPrice >= price && num > 0) { //deal
                            if (num >= iniNum) {
                                buyTree.remove(bidPrice);
                                buyMap.remove(bidPrice);
                                num -= iniNum;
                            } else {
                                iniNum -= num;
                                num = 0;
                                buyMap.remove(bidPrice);
                                buyMap.put(bidPrice, iniNum); //update number of stocks
                            }
                            stockPrice = Integer.toString(price);
                            if (buyTree.isEmpty()) {
                                break;
                            }
                            bidPrice = buyTree.last();
                            iniNum = buyMap.get(bidPrice);
                        }
                        if (num > 0) {
                            if (sellMap.containsKey(price)) {
                                int preNum = sellMap.get(price);
                                sellMap.remove(price);
                                sellMap.put(price, preNum + num);
                            } else {
                                sellTree.add(price);
                                sellMap.put(price, num);
                            }
                        }

                    }


                }
                String a = "-", b = "-";

                if (!sellTree.isEmpty()) a = Integer.toString(sellTree.first());
                if (!buyTree.isEmpty()) b = Integer.toString(buyTree.last());

                pr.println(a + " " + b + " " + stockPrice);
            }
        }
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
