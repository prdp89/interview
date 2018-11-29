package com.interview.hackerrank.recursion;

public class CountHit2 {

    //https://codingbat.com/prob/p143900
    public static void main( String[] args ) {
        System.out.println(countHi2("hihihi"));
    }

    //failed just 2 test case
    private static int countHi2( String str ) {

        if(str.length() < 3)
            return 0;

        int sum = (!str.substring(0, 3).equals("xhi") ?
                (str.substring(1, 3).equals("hi")
                        ? 1 + countHi2(str.substring(3))
                        : str.substring(0,2).equals("hi") ? 1 + countHi2(str.substring(2)) :
                        countHi2(str.substring(3)))
                : countHi2(str.substring(3))
        );

        return sum;
    }

    //all pass
    private static int countHi2Optimal(String str) {

        return (str.length() < 2)? 0 :

                (str.substring(0,2).equals("xh"))?

                        countHi2Optimal(str.substring(2)):

                        (str.substring(0,2).equals("hi"))?

                                1 + countHi2Optimal(str.substring(1)):

                                countHi2Optimal(str.substring(1));
    }
}