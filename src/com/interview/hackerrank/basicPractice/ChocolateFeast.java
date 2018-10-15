package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class ChocolateFeast {

    //https://www.hackerrank.com/challenges/chocolate-feast/problem
    public static void main( String[] args ) {
        //solve();
        solveOptimal();
    }

    //Only 2 test case passed with this; Think more dude :D
    private static void solve() {

        int n, c, m;

        n = 15;
        c = 3;
        m = 2;

        int bars = 0;

        int pendingWrapper = n % c;

        while (n >= 0) {

            bars += n / c;

            int wrappers = n / c + pendingWrapper;

            if (wrappers >= m) {
                n = (wrappers / m) * c;
                pendingWrapper = wrappers % c;
            } else
                break;
        }

        System.out.println(bars);
    }

    private static void solveOptimal() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int m = in.nextInt();

        int chocs = n / c;  //chocolates bought with Money
        int wrapper = chocs; //wrappers from chocolate
        int ex_chocs = wrapper / m; //chocolates from wrappers

        while (wrapper >= m) {
            ex_chocs = ex_chocs + (wrapper / m + wrapper % m) / m;
            wrapper = wrapper / m;
        }

        System.out.println(chocs + ex_chocs);

        //more optimization
       /* while(wrapper >= m) {
            int ex_chocs = wrapper / m;
            wrapper = ex_chocs + wrapper % m;
            chocs += ex_chocs;
        }
        System.out.println(chocs);*/

    }
}
