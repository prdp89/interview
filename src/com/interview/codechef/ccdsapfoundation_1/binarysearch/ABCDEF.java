package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABCDEF {

    //https://www.spoj.com/problems/ABCDEF/
    public static void main( String[] args ) {

        try {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();

        /*
        They asked us to find the number of plausible sextuples satisfying the following equation

        (a*b+c)/d - e= f

        Given the values for set S you take it for every element of a,b,c,d,e,f and make sets.

        Solution :

        Rearrange the equation as (a*b+c)=(e+f)*d
         */

            HashMap<Integer, Integer> count1 = new HashMap<>();
            HashMap<Integer, Integer> count2 = new HashMap<>();

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    for (int k = 0; k < n; k++) {

                        count1Compute(count1, arr[i] * arr[j] + arr[k]);

                        //computing second equation
                        if (arr[k] != 0)
                            count1Compute(count2, (arr[i] + arr[j]) * arr[k]);
                    }
                }
            }

            /*
            let the value 24 occur 3 times in LHS array and 4 times in RHS array.
            That is, values of a,b,c can be arranged in 3 ways in order to get 24 as answer
            to the LHS and value of d,e,f can be arranged in 4 ways to get 24 as RHS.
            each of the 3 possibilities of a,b,c have 4 possibilities of rearranging d,e,f.
            hence you can reorder a,b,c,d,e and f in 3*4 = 12 ways to satisfy the equation.
             */
            int total = 0;
            for (Map.Entry<Integer, Integer> entry : count1.entrySet()) {
                if (count2.containsKey(entry.getKey())) {
                    total += entry.getValue() * count2.get(entry.getKey());
                }
            }

            System.out.println(total);
        } catch (Exception e) {
            return;
        }
    }

    private static void count1Compute( HashMap<Integer, Integer> LHS, Integer lhs ) {
        LHS.compute(lhs, ( key, val ) -> {
            if (val == null) {
                return 1;
            } else {
                return val + 1;
            }
        });
    }

    //dont need since LHS can return valid result by reference
   /* private static void count2Compute( HashMap<Integer, Integer> RHS, Integer rhs ) {
        RHS.compute(rhs, ( key, val ) -> {
            if (val == null) {
                return 1;
            } else {
                return val + 1;
            }
        });
    }*/
}
