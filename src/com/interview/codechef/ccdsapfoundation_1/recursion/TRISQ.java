package com.interview.codechef.ccdsapfoundation_1.recursion;

import java.util.Scanner;

public class TRISQ {

    //https://www.codechef.com/problems/TRISQ
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int base = scanner.nextInt();

        //https://discuss.codechef.com/t/trisq-editorial/9632
        /*
        If we consider the position of first square with the vertex Y, we will have:
        (B/2−1)
        squares in the base, and we will be left with another isosceles right angle triangle having base length
        (B−2) */

        /*
        If base is 4 then x is also 4 then hypotesis is : root of 2 . 4
        If we have base = 4 and x = 4 then we can fill (base /2 )- 2 squares
        Then we have left with small triangle with Base - 2 (bcz we need to fill with 2*2 squares)
         */

        int ans = 0;
        while (base > 2) {
            ans += (base - 2) / 2;
            base = base - 2;
        }

        System.out.println(ans);
    }
}
