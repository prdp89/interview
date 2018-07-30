package com.interview.codingblocks.week2;

import java.util.Scanner;

//Question : https://hack.codingblocks.com/contests/c/473/1251
// for reference of a^b : https://www.hackerearth.com/practice/notes/number-theory-1/
public class MathDay {

    public static void main( String[] args ) {
        solve();
    }

    private static long modPowIter( long A, long N, int P ) {
        long ans = 1;
        while (N != 0) {
            if (N % 2 == 1)
                ans = (ans * A) % P;

            A = (A * A) % P;
            N /= 2;
        }
        return ans;
    }

    //Compute A^N! %P.
    //so we don't need to calculate N! since N can be upto 10^5
    //trick is, we are calculating  (((((a^1)%p)^2)%p)^3)%p)^4%p)...)^n)%p : where 1..N are N values only :)
    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        while (test-- > 0) {
            int A = scanner.nextInt();
            int N = scanner.nextInt();
            int P = scanner.nextInt();

            //we don't need to calculate (A^1) so directly A%P will work.
            long ans = A % P;

            for (long i = 2; i <= N; ++i) {
                //now : ans ^ i % P
                //this prevent to calculate N! and wrong answer in some cases. :)
                ans = modPowIter(ans, i, P);
            }

            System.out.println(ans);
        }
    }
}
