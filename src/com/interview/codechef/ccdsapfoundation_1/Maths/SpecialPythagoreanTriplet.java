package com.interview.codechef.ccdsapfoundation_1.Maths;

public class SpecialPythagoreanTriplet {

    //https://projecteuler.net/problem=9
    public static void main( String[] args ) {
        triplet();
    }

    //similar to TripletSumLessThanTotal inside array package
    private static void triplet() {
        int a, b, c;
        for (a = 0; a <= 1000; a++) {

            for (b = a + 1; b <= 1000; b++) // no point starting from 0, otherwise you'll just try the same solution more than once. The condition says a < b < c.
            {

                for (c = b + 1; c <= 1000; c++) // same, this ensures a < b < c.
                {

                    if (((a * a + b * b == c * c) && ((a + b + c) == 1000))) // ^ is the bitwise xor operator, use multiplication for squaring
                        System.out.printf("a=%d, b=%d, c=%d", a, b, c);
                }
            }
        }
    }
}
