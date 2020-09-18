package com.interview.codechef.ccdsapfoundation_1.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CNOTE {

    //https://www.codechef.com/MARCH15/problems/CNOTE

    public static void main( String[] args ) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                String[] parts = br.readLine().trim().split("\\s+"); // split on whitespace

                int x = Integer.parseInt(parts[0]); //x pages long poetry
                int y = Integer.parseInt(parts[1]); //y pages left
                int k = Integer.parseInt(parts[2]); //his budget
                int n = Integer.parseInt(parts[3]); //number of Pi and Ci

                int requiredPage = x - y;
                boolean isChefLucky = false;
                while (n-- > 0) {

                    parts = br.readLine().trim().split("\\s+");

                    int pages = Integer.parseInt(parts[0]);
                    int cost = Integer.parseInt(parts[1]);

                    /*
                    The problem with this code is that if you found a good notebook early on,
                   it immediately breaks out of the loop, failing to read all (Pi, Ci) pairs.

                   So it fails to read the next case properly, possibly causing TLE/WA/RE verdicts,
                   depending on how the next few numbers are interpreted.
                     */
                    if ((pages >= requiredPage && cost <= k)) {
                        // System.out.println("LuckyChef");
                        isChefLucky = true;
                        // break;
                    }
                }

                System.out.println(isChefLucky ? "LuckyChef" : "UnluckyChef");
            }
        } catch (Exception e) {
            return;
        }
    }
}
