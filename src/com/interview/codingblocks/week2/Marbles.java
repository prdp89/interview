package com.interview.codingblocks.week2;


import java.util.Scanner;

//question: https://hack.codingblocks.com/contests/c/452/759
//Tutorial: https://unacademy.com/lesson/problems-with-solutions-marbles/RMLQXDEO
//spoj : https://www.spoj.com/problems/MARBLES/
//This question uses beggars method of Combination.
public class Marbles {

    /*
    Using Beggars Method Of Combination :
    For sequence : X1 + X2 + X3 +...Xk = N (where x1, x2, x3 >= 0)
    Example: Beggars Method is used when we have N coins and we need to distribute among K Beggars
    formula = (N + K - 1) C (K -1)
    Marbles: We have N marbles, we have to pick K marbles, should be of different color.
    So, we need to modify beggars formula a little:
    It's like we have assign : First marbles as  -> Then first marbles is already taken so
     */
    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();

        while (test-- > 0) {
            long n, k, ans;

            n = scanner.nextLong();
            k = scanner.nextLong();

            //if n < k = there will be no possible combinations
            if (n < k)
                ans = 0;
            else if (n == k)
                ans = 1;
            else {

                //default answer will be 1 only
                ans = 1;

                //now we need to calculate N-1 C K-1 ; so subtract n-- & K--
                n = n - 1;
                k = k - 1;

                long division, multiplication;
                division = 1;
                multiplication = n;

                //Now this method is same as Bionomial Coeffcient calculation
                k = Math.min(k, n - k);

                while (division <= k) {
                    ans = (ans * multiplication--) / division++;
                }
            }
            System.out.println(ans);
        }
    }

    public static void main( String[] args ) {
        solve();
    }
}
