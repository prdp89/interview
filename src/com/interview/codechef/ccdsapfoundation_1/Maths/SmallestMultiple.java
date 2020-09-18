package com.interview.codechef.ccdsapfoundation_1.Maths;

public class SmallestMultiple {

    //https://projecteuler.net/problem=5
    public static void main( String[] args ) {
        System.out.println(smallestMultiple());
    }

    private static long smallestMultiple() {

        boolean found = true;
        long result = 0;
        for (long i = 2520; found; i += 2520) { //if 1...10 smallest is 2520 for 20 we should start by 2520

            //if 11---20 MOD 2520 == 0 then res is 2520 else increase by atleast 2520
            if (i % 11 != 0 || i % 12 != 0 || i % 13 != 0 ||
                    i % 14 != 0 || i % 15 != 0 || i % 16 != 0 ||
                    i % 17 != 0 || i % 18 != 0 || i % 19 != 0 || i % 20 != 0) continue;

            result = i;
            found = false;
        }

        return result;
    }
}
