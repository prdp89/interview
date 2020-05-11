package com.interview.leetcode.contests.contest188;

public class CountTriplets {

    public static void main( String[] args ) {
        int[] arr = {2, 3, 1, 6, 7};
        System.out.println(countTriplets(arr));
        System.out.println(countTripletsPrefix(arr));
    }

    private static int countTriplets( int[] arr ) {

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int xor = 0;

            for (int j = i; j < arr.length; j++) {

                xor ^= arr[j];

                // just find the sub-array that xor equals 0,
                //eg: 2^ 4 ^ 3 => 0
                //eg: 1^ 2 ^ 3 => 0
                //if two pairs XOR value is zero, means a == b
                if (xor == 0) {
                    count += j - i;
                }
            }
        }

        return count;
    }

    private static int countTripletsPrefix( int[] arr ) {
        int n = arr.length, res = 0, prefix[] = new int[n + 1];

        //not needed
        //prefix[0] = 0;

        //prefix should loop till n + 1
        for (int i = 1; i <= n; i++) {
            prefix[i] = arr[i - 1] ^ prefix[i - 1];
        }

        //loop similar to TripletInArray
        for (int i = 0; i <= n; i++) {

            for (int j = i + 1; j <= n; j++) {

                if (prefix[i] == prefix[j]) //subarrays where a == b
                    res = res + j - i - 1; //j - i - 1 : number of subarrays between J & I
            }
        }

        return res;
    }
}
