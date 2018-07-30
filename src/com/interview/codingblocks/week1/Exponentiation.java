package com.interview.codingblocks.week1;

public class Exponentiation {

    static int fastPower( int a, int b ) {
        //Base Case
        if (b == 0) {
            return 1;
        }
        int smallValue = fastPower(a, b / 2);
        smallValue *= smallValue;

        if (b % 2 == 1) {
            return a * smallValue;
        }
        return smallValue;
    }

    //Fast Power using Bitmasking
    static int fastPowerBitmasks( int a, int b ) {

        int res = 1;
        while (b > 0) {

            int last_bit = (b & 1);
            if (last_bit > 0) {
                res *= a;
            }
            a = a * a;
            b = b >> 1;
        }
        return res;
    }


    public static void main( String[] args ) {
        System.out.println(fastPowerBitmasks(2, 3));
    }
}
