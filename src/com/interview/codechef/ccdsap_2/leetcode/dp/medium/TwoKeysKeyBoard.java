package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class TwoKeysKeyBoard {

    //https://leetcode.com/problems/2-keys-keyboard/
    public static void main( String[] args ) {
        System.out.println(minSteps(4));
    }

    //This problem is a variation of MaxWith4Keys : In this problem we have given number of keys and we have to print max A's

    //But TwoKeysBoard : In this we have given number of A's and we need to find the min. operation to get those A's
    //So, to get the number of A's min. operation we need to find divisors of A (N/d) where N is number of A's

    //Divisor 'd' indicates number of operation performed to get N A's
    //Eg : If N = 4 {we need to find min. operation to get 4 A's} :
    //4 is divisible by 2 so Min. operation required is 4 {1st operation to copy-all then 2nd paste 3rd Copy 4th Paste)

    private static int minSteps( int n ) {

        int s = 0;

        //this Logic is similar to LargestPrimeFactor in maths -> ccdsap_1
        for (int d = 2; d <= n; d++) {

            while (n % d == 0) {

                //diff. is we need all factors sum for min. number of operation.
                s += d;
                n /= d;
            }
        }
        return s;
    }
}
