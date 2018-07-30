package com.interview.codingblocks.week5numbertheory;

import java.util.Scanner;

public class LightsNewCar {

    private static long MOD = 1000000007;

    //https://hack.codingblocks.com/contests/c/473/92
    //Description written in notes : basicaly fast computing of X ^ Y

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test-- > 0) {

            String a = scanner.next();
            String b = scanner.next();

            //step 1 : reduce the number by MOD
            long x = stringToInt(a.toCharArray(), MOD);
            long y = stringToInt(b.toCharArray(), MOD - 1);

            //Step 2: compute power x ^ y
            long answer = power(x, y);

            System.out.println(answer);
        }
    }

    private static long power( long x, long y ) {

        if (y == 0)
            return 1;

        //recursive x ^ y / 2
        long smallPower = power(x, y/2);

        smallPower%=MOD;

        smallPower = (smallPower * smallPower) % MOD;

        //if y is odd or last digit is not equals to zero..
        if((y&1) != 0)
            return (x * smallPower) % MOD;

        return smallPower;
    }

    private static long stringToInt( char[] a, long mod ) {
        long ans = 0;

        for (char anA : a) {
            //getting each digit and taking mod each digit
            ans = ((ans * 10) % mod) + (anA - '0');

            //reducing digit by mod 'm'
            ans %= mod;
        }

        return ans;
    }
}
