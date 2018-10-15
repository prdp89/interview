package com.interview.codingblocks.week7Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BiasedStandings {

    //https://www.spoj.com/problems/BAISED/
    public static void main( String[] args ) {
        //solve();
        solveOptimal();
    }

    //This problem is similar to connecting wires in Competitive Programming book.
    //Complexity : O(n Log n)
    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        while (test-- > 0) {

            int participants = scanner.nextInt();

            int[] arr = new int[participants];

            for (int i = 0; i < participants; i++) {
                scanner.next();
                int desriredRank = scanner.nextInt();

                arr[i] = desriredRank;
            }

            Arrays.sort(arr);

            //Now we are assigning rank to each team from 1..N and,
            //calculating difference in their desired rank and assigned rank.
            //The difference is called badness in rank-list.
            //sum of difference is our answer.
            int sum = 0;
            for (int i = 1; i <= participants; i++) { //loop starts from 1 : bcz we are giving rank from 1..N

                sum += Math.abs(i - arr[i - 1]); //subtracting Rank - Desired rank and ABS provide actual difference
            }

            System.out.println(sum);
        }
    }

    //We don't need sorting if we are maintaining frequency array of element.
    //Then we are subtracting those frequency by assigning rank to each participants.
    //complexity : O( N )
    private static void solveOptimal() {

        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        while (test-- > 0) {

            int participants = scanner.nextInt();

            int[] arr = new int[100000 + 10];

            for (int i = 0; i < participants; i++) {
                scanner.next();
                int desriredRank = scanner.nextInt();

                //assigning each desired rank to frequency array
                arr[desriredRank]++;
            }

            long pos = 1, sum = 0;
            for (int i = 1; i <= participants; i++) {

                //loop to check if there more than one person have same desired rank.
                while (arr[i] != 0) {

                    //here pos is assigning each individual a rank.
                    //we are subtracting from 'i' : desired position
                    sum += Math.abs(i - pos);

                    pos++;

                    //if there's more than one person has same rank assigned
                    arr[i]--;
                }
            }

            System.out.println(sum);
        }
    }
}
