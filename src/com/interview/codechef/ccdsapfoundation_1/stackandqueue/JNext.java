package com.interview.codechef.ccdsapfoundation_1.stackandqueue;

import java.util.Scanner;

//https://www.spoj.com/problems/JNEXT/
public class JNext {

    //ref : https://codeforces.com/blog/entry/3980
    //explanation : https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = scanner.nextInt();
            Comparable[] comp = new Comparable[n];

            for (int i = 0; i < n; i++) {
                comp[i] = scanner.nextInt();
            }

            printPermutations(comp);
        }

    }

    // simply prints all permutation - to see how it works
    private static void printPermutations( Comparable[] c ) {
        nextPermutation(c);

        for (Comparable ch : c) {
            System.out.print(ch);
        }

        //Commented to generate just next greater element
      /*  while ((c = nextPermutation(c)) != null) {
            System.out.println(Arrays.toString(c));
        }*/
    }

    // modifies c to next permutation or returns null if such permutation does not exist
    private static Comparable[] nextPermutation( final Comparable[] c ) {
        // 1. finds the largest k, that c[k] < c[k+1]
        int first = getFirst(c);

        if (first == -1) return null; // no greater permutation

        // 2. find last index toSwap, that c[k] < c[toSwap]
        int toSwap = c.length - 1;
        while (c[first].compareTo(c[toSwap]) >= 0)
            --toSwap;

        // 3. swap elements with indexes first and last
        swap(c, first++, toSwap);

        // 4. reverse sequence from k+1 to n (inclusive)
        toSwap = c.length - 1;
        while (first < toSwap)
            swap(c, first++, toSwap--);
        return c;
    }

    // finds the largest k, that c[k] < c[k+1]
    // if no such k exists (there is not greater permutation), return -1
    private static int getFirst( final Comparable[] c ) {
        for (int i = c.length - 2; i >= 0; --i)
            if (c[i].compareTo(c[i + 1]) < 0)
                return i;
        return -1;
    }

    // swaps two elements (with indexes i and j) in array
    private static void swap( final Comparable[] c, final int i, final int j ) {
        final Comparable tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
}
