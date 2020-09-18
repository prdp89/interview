package com.interview.codechef.ccdsapfoundation_1.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FGFS {

    //https://www.codechef.com/problems/FGFS
    public static void main( String[] args ) {
        solve();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    private static void solve() {
        try {
            FastScanner scanner = new FastScanner();

            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();

                List<Restaurant> arr = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    arr.add(new Restaurant(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
                }

                Collections.sort(arr, new Restaurant());
              // or  Collections.sort(arr, (a, b) -> a.departure - b.departure);

                HashMap<Integer, Integer> map = new HashMap<>();
                int count = 0;

                for (int i = 0; i < n; i++) {

                    //if room contain some person
                    if (map.containsKey(arr.get(i).prefRoom)) {

                        int arrival = arr.get(i).arrival;

                        if (map.get(arr.get(i).prefRoom) <= arrival) { //if person A is leaving before B arrival's

                            map.put(arr.get(i).prefRoom, arr.get(i).departure);
                            count++;
                        }
                    } else {
                        map.put(arr.get(i).prefRoom, arr.get(i).departure);
                        count++;
                    }

                }

                System.out.println(count);
            }
        } catch (Exception e) {
            return;
        }
    }

    static class Restaurant implements Comparator<Restaurant> {

        int arrival;
        int departure;
        int prefRoom;

        Restaurant() {

        }

        Restaurant( int arrival, int departure, int prefRoom ) {
            this.arrival = arrival;
            this.departure = departure;
            this.prefRoom = prefRoom;
        }


        @Override
        public int compare( Restaurant o1, Restaurant o2 ) {
            return o1.departure - o2.departure;
        }
    }
}
