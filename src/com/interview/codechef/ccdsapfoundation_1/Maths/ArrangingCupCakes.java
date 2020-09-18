package com.interview.codechef.ccdsapfoundation_1.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrangingCupCakes {

    //https://www.codechef.com/FLMOCK04/problems/RESQ
    public static void main( String[] args ) throws IOException {
        System.out.println(solve());
    }

    private static int solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim().split("\\s+")[0]);
        int sqr = (int) Math.sqrt(n), r = 0, div;

        for (int i = sqr; i > 0; i--) {

            if (n % i == 0) {
                div = n / i;

                //two factors here : div , i
                r = div - i;
                break;
            }
        }
        return r;
    }
}
