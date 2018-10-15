package com.interview.codingblocks.week6recursion;

import java.util.Scanner;

public class CLASSASSIGNMENT {


    //https://hack.codingblocks.com/contests/c/452/875
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        //solve(scanner.nextInt() + 1, "", 0);

        System.out.println(solvOptimal(scanner.nextInt()));
    }

    private static void solve( int next, String input, int i ) {

        if (i == next - 1) {
            System.out.println(input);
            return;
        }

        if (input.length() < 1) {
            solve(next, input + "a", i + 1);
            solve(next, input + "b", i + 1);
        } else if (input.charAt(input.length() - 1) == 'a') {
            solve(next, input + "a", i + 1);
            solve(next, input + "b", i + 1);
        } else {
            solve(next, input + "a", i + 1);
        }
    }


    private static int solvOptimal( int n ) {
        int a[] = new int[n + 1];
        int b[] = new int[n + 1];

        a[0] = 0;
        a[1] = 1;

        b[0] = 0;
        b[1] = 1;

        /*

        if(n==1)
	    return 2;
        else if(n==2)
	    return 3;

         */

        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + b[i - 1]; //this is like a fibo. sequence
            b[i] = a[i - 1]; //we are replacing old a index with new b index. This is just like fibo. sequence
        }
        return a[n] + b[n];
    }
}
