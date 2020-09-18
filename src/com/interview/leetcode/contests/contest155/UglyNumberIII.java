package com.interview.leetcode.contests.contest155;

public class UglyNumberIII {

    //https://leetcode.com/contest/weekly-contest-155/problems/ugly-number-iii/
    public static void main( String[] args ) {
        int n = 3, a = 2, b = 3, c = 5;

        //System.out.println(nthUglyNumberBruteForce(n, a, b, c));

        System.out.println(nthUglyNumberOptimal(n, a, b, c));
    }

    //Logic here is simple: multiply every a,b,c, with 1 -> then find Min. out of it
    //Eg:  a = 2, b = 3, c = 5 ; min = 2
    //Since 2 is smallest increase its ai index and multiply next a with ai = 2 => 2 * 2 => 4

    //TIme complexity = O ( N )
    //42 / 50 test cases passed.
    private static int nthUglyNumberBruteForce( int n, int a, int b, int c ) {
        int ai = 1, bi = 1, ci = 1;
        int next = Math.min(a * ai, Math.min(b * bi, c * ci));

        for (int i = 1; i <= n; i++) {
            next = Math.min(a * ai, Math.min(b * bi, c * ci));

            if (next == a * ai) {
                ai++;
            }
            if (next == b * bi) {
                bi++;
            }
            if (next == c * ci) {
                ci++;
            }
        }
        return next;
    }

    //https://leetcode.com/problems/ugly-number-iii/discuss/387587/Math-BinarySearch-Solution-(JAVA)
    //https://leetcode.com/problems/ugly-number-iii/discuss/387539/cpp-Binary-Search-with-picture-and-Binary-Search-Template

    //This binary search logic is same as : PeakIndexMountainArray -> peakIndexInMountainArray_3
    private static int nthUglyNumberOptimal( int n, int a, int b, int c ) {
        int low = 1, high = Integer.MAX_VALUE, mid;

        while (low < high) {
            mid = low + (high - low) / 2;

            if (count((a), b, c, mid) < n)
                low = mid + 1;
            else
                high = mid;
        }

        return high;
    }

    private static long gcd( long a, long b ) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    private static long lcm( long a, long b ) {
        return (a * b) / gcd(a, b);
    }

    private static int count( long a, long b, long c, long num ) {
        //F(N) = a + b + c - a ∩ c - a ∩ b - b ∩ c + a ∩ b ∩ c
        //F(N) = N/a + N/b + N/c - N/lcm(a, c) - N/lcm(a, b) - N/lcm(b, c) + N/lcm(a, b, c)(lcm = least common multiple)

        return (int) ((num / a) + (num / b) + (num / c)
                - (num / lcm(a, b))
                - (num / lcm(b, c))
                - (num / lcm(a, c))
                + (num / lcm(a, lcm(b, c)))); // lcm(a,b,c) = lcm(a,lcm(b,c))
    }
}