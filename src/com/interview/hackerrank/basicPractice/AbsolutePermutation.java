package com.interview.hackerrank.basicPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AbsolutePermutation {

    //https://www.hackerrank.com/challenges/absolute-permutation/problem
    //https://www.geeksforgeeks.org/k-difference-permutation/
    //lexicographically factorial with K difference

    public static void main( String[] args ) {
        solve();
    }


    /*
    pos[i]	i	|Difference|
    3	    1	    2
    4	    2	    2
    1	    3   	2
    2	    4	    2

     */

    /*
    There are many clever solutions in the discussion, but they aren't exactly straightfoward to me,
    so I've worked out myself.

    First, there are two exception cases, like below:

    Step 1: k == 0: print all the numbers from 1 to N

    Step 2 : if (n / k) % 2 is not ZERO, print -1 (as this must be zero to be absolute factorial)

    Otherwise, follow the pattern below:

    Step 3 :

    if we go from 1 to N (i),

    Permutation is either i+k or i-k. It always starts with i+k.

    step 3.1 : Put i+k to permutaion for k times

    step 3.2 : Switch to i-k for k times

    repeat 1 & 2 until the end.
     */
    private static void solve() {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        //step 1 :
        //Diff. is zero, so we cannot shift elements
        if (k == 0) {

            for (int i = 1; i <= n; i++)
                System.out.print(i + " ");
        }

        //step 2 :
        /*
        Another way to look at it is if n % (2*k) is not ZERO, print -1.
        That's because you'll need to "shuffle" groups of 2*k elements.

        For example, when n = 8 and k = 2, you'll start off with [1,2,3,4,5,6,7,8] and shuffle groups of 4 like this:

        1 and 3

        2 and 4

        -

        5 and 7

        6 and 8

        ...

        The approach works in this case because 8 is divisible by 4.
        Or more generally, it will work when n is divisible by 2*k.
         */

        else if (n % (2 * k) != 0)
            System.out.println("-1");
        else {

            boolean add = true;
            List<Integer> permutations = new ArrayList<>();

            for (int i = 1; i <= n; i++) {

                if (add)
                    permutations.add(i + k);
                else
                    permutations.add(i - k);

                if (i % k == 0) {
                    if (add)
                        add = false;
                    else
                        add = true;
                }
            }

            for (int item : permutations)
                System.out.print(item + " ");
        }
    }
}
