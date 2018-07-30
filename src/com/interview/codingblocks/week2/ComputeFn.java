package com.interview.codingblocks.week2;

import java.util.Scanner;

public class ComputeFn {

    //question : https://hack.codingblocks.com/contests/c/473/68
    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        long test = scanner.nextInt();

        while (test-- > 0) {

            long n = scanner.nextLong();
            long result;

            //using AP progression here f(n) = (n * (2A + (n - 1) * d))/2 where A = first number , d= difference of element in series
            //we are calculating odd and even differently
            if ((n & 1) != 0) {

                //series : -1 + 2 -3 + 4 .....
                //so, we are dividing series into posNum : 2 + 4 + .. , negSum : -1 - 2 - 5....
                long posNum =  n / 2;

                long negNum = (n / 2 + 1);

                //result = - negNum series + postNum series
                //result = -(n * (2A + (n - 1) * d))/2 + ((n * (2A + (n - 1) * d))/2)

                result = -(long)((long)(negNum) * (2 + (long)((negNum - 1) * 2)))/2 +
                        (long)(posNum *(long) (4 + (posNum - 1) * 2))/2;

            } else {
                long posNum = (long) (n / 2);

                //if n is even then negative series is divided by 2. So no need to +1 here..
                long negNum = (long) (n / 2);

                result = -(long)(negNum * (long)(2 +(long)( (negNum - 1) * 2)))/2 +
                        (long)(posNum *(long) (2 * 2 +(long)((posNum - 1) * 2)))/2;
            }

            System.out.println(result);
        }

    }

    public static void main( String[] args ) {
        solve();
    }
}
