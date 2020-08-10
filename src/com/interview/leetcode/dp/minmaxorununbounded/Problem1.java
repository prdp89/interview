package com.interview.leetcode.dp.minmaxorununbounded;

import java.math.BigInteger;

public class Problem1 {

    public static void main( String[] args ) {
        // System.out.println(binaryToInteger(3));
        //System.out.println(solveAgain(3));

        //System.out.println(solveAgain(3));

        System.out.println(solve(3));
    }

    /* private static long solveAgain( long n ) {
         long res = 0;
         for (long i = 1; i <= n; i++) {
             res = concat(res, i);
         }

         return (res);
     }

     static void decBinary( long arr[], long n ) {
         long k = (long) (Math.log(n) /
                 Math.log(2));

         while (n > 0) {
             arr[(int) k--] = n % 2;
             n /= 2;
         }
     }


     static long binaryDec( long arr[], long n ) {
         long ans = 0;

         for (long i = 0; i < n; i++)
             ans += arr[(int) i] << (n - i - 1);

         return ans;
     }

     static long concat( long m, long n ) {

         // Number of bits in both the numbers
         long k = (long) (Math.log(m) /
                 Math.log(2)) + 1;
         long l = (long) (Math.log(n) /
                 Math.log(2)) + 1;

         // Convert the bits in both the integers
         // to the arrays a[] and b[]
         long a[] = new long[(int) k];
         long b[] = new long[(int) l];

         // c[] will be the binary array
         // for the result
         long c[] = new long[(int) (k + l)];
         decBinary(a, m);
         decBinary(b, n);

         // Update the c[] array
         int in = 0;
         for (int i = 0; i < k; i++)
             c[in++] = a[i];
         for (int i = 0; i < l; i++)
             c[in++] = b[i];

         // Return the decimal equivalent
         // of the result
         return (binaryDec(c, k + l));
     }
 */
    private static long solveAgain( long n ) {
        String result = "0";
        for (long i = n; i >= 1; i--) {
            result = addBinaryUtil(result, Long.toBinaryString(i));
        }

        return new BigInteger(result, 2).longValue() % (long) (1e9 + 7);
    }

    static String addBinaryUtil( String a, String b ) {
        String result = ""; // Initialize result
        int s = 0; // Initialize digit sum

        // Traverse both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {

            // Compute sum of last digits and carry
            s += ((i >= 0) ? a.charAt(i) - '0' : 0);
            s += ((j >= 0) ? b.charAt(j) - '0' : 0);

            // If current digit sum is 1 or 3,
            // add 1 to result
            result = s % 2 + result;

            // Compute carry
            s /= 2;

            // Move to next digits
            i--;
            j--;
        }
        return result;
    }

    private static long solve( long n ) {
        StringBuilder sb = new StringBuilder();

        for (long i = 1; i <= n; i++) {
            sb.append(Long.toBinaryString(i));
        }

        Long res = new BigInteger(sb.toString(), 2).longValue();
        return (res + (long) (Math.pow(10, 9) + 7)) % (long) (Math.pow(10, 9) + 7);

        //return (makeLong(sb.toString()) + (long) (Math.pow(10, 9) + 7)) % (long) (Math.pow(10, 9) + 7);
    }

    public static long makeLong( String input ) {
        if (input.substring(0, 1).equals("1")) {
            return -1 * (Long.MAX_VALUE - Long.parseLong(input.substring(1), 2) + 1);
        } else {
            return Long.parseLong(input, 2);
        }
    }

    private static long binaryToInteger( long n ) {

        StringBuilder sb = new StringBuilder();

        for (long i = 1; i <= n; i++) {
            sb.append(Long.toBinaryString(i));
        }

        char[] numbers = sb.toString().toCharArray();
        long result = 0;

        int count = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {

            if (numbers[i] == '1')
                result += (int) Math.pow(2, count) % (long) (1e9 + 7);

            count++;
        }

        return result % (long) (1e9 + 7);
    }
}
