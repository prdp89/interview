package com.interview.codechef.ccdsapfoundation_1.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BearAndSegment01 {

    public static void main( String[] args ) {
        solve();
    }

    //passing 50% of test cases;
    //Solution : Find start index of 1 and end index of 1; iF start--> index doesn't contain zero ? true : false
    //If all zero's in input return false
    private static void solve() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine().trim().split("\\s+")[0]);

            while (t-- > 0) {

                String str = br.readLine().trim();
                int ones = 0;

                for (int i = 0; i < str.length() - 1; i++) {

                    if (str.charAt(i) == '1' && ones == 0)
                        ones = 1;
                    else if (str.charAt(i) == '0' && ones == 1 && str.charAt(i + 1) == '1') {
                        ones = 0;
                        break;
                    }
                }

                if (ones == 0)
                    System.out.println("NO");
                else
                    System.out.println("YES");
            }
        } catch (Exception e) {
            return;
        }
    }
}
