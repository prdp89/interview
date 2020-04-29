package com.interview.companies.fb;

public class NumberOf1Bits {

    //https://leetcode.com/problems/number-of-1-bits/
    public static void main( String[] args ) {
        int nU = Integer.parseUnsignedInt("00000000000000000000000000001011");

        System.out.println(hammingWeight(nU));

        System.out.println(hammingWeightOPtimal(nU));
    }

    //no success
    private static int hammingWeight( int n ) {
        String str = String.valueOf(Integer.parseUnsignedInt(n + ""));

        int ones = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == '1')
                ones++;

        return ones;
    }

    //it's a Brian Karnighan's algorithm
    //https://leetcode.com/problems/number-of-1-bits/discuss/55099/Simple-Java-Solution-Bit-Shifting
    /*
    An Integer in Java has 32 bits, e.g. 00101000011110010100001000011010.
    To count the 1s in the Integer representation we put the input int
    n in bit AND with 1 (that is represented as
    00000000000000000000000000000001, and if this operation result is 1,
    that means that the last bit of the input integer is 1. Thus we add it to the 1s count.
     */
    private static int hammingWeightOPtimal( int n ) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}
