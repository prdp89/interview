package com.interview.codingblocks.week3;


import java.text.DecimalFormat;
import java.util.Scanner;

//This problem is same as Coupon Collector in diary or
// DiceRollExpectation problem ,read a blog for that.
public class FavDiceCopuonCollector {

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        DecimalFormat df = new DecimalFormat("0.00");

        while (t-- > 0) {
            int N = scanner.nextInt();

            double ans = 0;
            for (int i = 1; i <= N; i++) {
                ans += N / (i * 1.0);
            }

            System.out.println(df.format(ans));
           // System.out.println(Math.round(ans * 100.0) / 100.0);
        }
    }
}
