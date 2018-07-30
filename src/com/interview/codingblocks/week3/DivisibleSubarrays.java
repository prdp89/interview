package com.interview.codingblocks.week3;

import java.util.Scanner;

//video link : https://www.youtube.com/watch?v=QQQpOa3aXew
//GFG link : https://www.geeksforgeeks.org/count-sub-arrays-sum-divisible-k/
public class DivisibleSubarrays {

    private static void solveBruteForce() {

        int arr[] = {4, 5, 0, -2, -3, 1};

        int k = 5;

        int totalSubArrays = 0;
        for (int i = 0; i < arr.length; i++) {

            int sum;
            for (int j = i; j < arr.length; j++) {

                sum = j;
                if (sum % 5 == 0) {
                    totalSubArrays++;
                }

                sum += j;
            }
        }

        /*
        Output : 7
        // there are 7 sub-arrays whose is divisible by K
        // {4, 5, 0, -2, -3, 1}
        // {5}
        // {5, 0}
        // {5, 0, -2, -3}
        // {0}
        // {0, -2, -3}
        // {-2, -3}
         */

        System.out.println(totalSubArrays);

        //if K = 10 ^ 6 then brute force will not work
    }

    //video link: https://www.youtube.com/watch?v=QQQpOa3aXew
    //question: https://hack.codingblocks.com/contests/c/473/266
    private static void solvePigeonHole() {

        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        while (test-- > 0){
            long arr[] = new long[1000005]; //stores array values
            long prefixSum[] = new long[1000005]; //stores frequency of numbers divisors

            //check Divisible subarrays in Axis bank diary 07/09/18.
            prefixSum[0] = 1;

            //N denotes number of elements or used to calculate Sum of Subarrays MOD N.
            int N = scanner.nextInt();
            long sum = 0;

            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextLong();

                //calculating Sum till ith elements or prefix sum
                sum = sum + arr[i];

                //calculate Sum % N : this helps in numbers of unique values (eg. 1 or 0) that is divisible by N
                sum = sum % N;

                //so sum can be negative
                //to take MOD of -ve numbers: (num + MODVALUE) % MODVALUE
                //if sum = -3 : (-3 + 5) % 5 => 2
                sum = (sum + N) % N;

                //to maintain number of divisors by each index. Increase the frequency if divisors repeats
                prefixSum[(int) sum]++;
            }

            long ans = 0;
            for (int i = 0; i < N; i++) {
                // System.out.println(prefixSum[i]);
                long number = prefixSum[i];

                //now calculating N C 2 : acc. to pigeonhole formula (b-a)%N == 0
                //So to do this, we have to pick TWO subarrays and calculate (B - A) of it.
                //Suppose : current prefix[index] = 3 , then there are 3 subarrays which are calculated acc. to (B - A) exclusion of subset formula.
                //to calculate N C 2 formula : (Num * (Num - 1)) / 2

                number = (number * (number - 1)) / 2;

                ans += number;
            }

            System.out.println(ans);
        }
    }

    public static void main( String[] args ) {

        // solveBruteForce();

        solvePigeonHole();
    }
}
