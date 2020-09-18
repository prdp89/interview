package com.interview.codechef.ccdsapfoundation_1.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountSubarrays {

    //https://www.codechef.com/FLMOCK04/problems/SUBINC
    public static void main( String[] args ) {
        countSubArr();
    }

    //just failing one test case :(
    private static void countSubArr() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine().trim().split("\\s+")[0]);

            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim().split("\\s+")[0]);
                String[] str = br.readLine().trim().split("\\s+");

                int count = 1, ans = 0;
                for (int i = 1; i < str.length; i++) {

                    //(count * (count + 1) : help in genrate number of possible substring if a[i+1] < a[i]
                    if ((Integer.parseInt(str[i]) < Integer.parseInt(str[i - 1]))) {
                        ans += ((count * (count + 1)) / 2);
                        count = 0;
                    }

                    count++;
                }

                //if count is still there..
                System.out.println(ans + ((count * (count + 1)) / 2));
            }
        } catch (Exception e) {
            return;
        }
    }
}