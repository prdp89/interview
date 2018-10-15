package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class ACMICPCTeam {

    //THis solution is correct logically..
    private static void solve() {
        String[] topic = {"10101",
                "11100",
                "11010",
                "00101"};

        Scanner scanner = new Scanner(System.in);
        scanner.nextBigInteger(2);

        int[] a = new int[topic.length];

        for (int i = 0; i < topic.length; i++) {

            int decimal = Integer.parseInt(topic[i], 2);
            a[i] = decimal;
        }

        int maxBitCount, maxScoreCount;

        maxBitCount = maxScoreCount = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int k = a[i] | a[j];

                int bitCount = 0;

                while (k != 0) {
                    k &=  (k - 1);
                    bitCount++;
                }

                if(bitCount > maxBitCount) {
                    maxBitCount = bitCount;
                    maxScoreCount = 1;
                } else if(bitCount == maxBitCount) {
                    maxScoreCount++;
                }
            }
        }

        System.out.println(maxBitCount);
        System.out.println(maxScoreCount);
    }


    /*
    //TO pass all test case , input should be of type bigInteger
     public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numOfPeople = scanner.nextInt();
    int numOfTopics = scanner.nextInt();
    BigInteger[] familiarity = new BigInteger[numOfPeople];
    int maxBitCount = 0;
    int maxScoreCount = 0;
    BigInteger score;

    for(int i=0; i<numOfPeople; i++) {
        familiarity[i] = scanner.nextBigInteger(2);
    }

    for(int i=0; i<familiarity.length-1; i++) {
        for(int j=i+1; j<=familiarity.length-1; j++) {
            score = familiarity[i].or(familiarity[j]);
            int bitCount = score.bitCount();
            if(bitCount > maxBitCount) {
                maxBitCount = bitCount;
                maxScoreCount = 1;
            } else if(bitCount == maxBitCount) {
                maxScoreCount++;
            }
        }
    }
    System.out.println(maxBitCount);
    System.out.println(maxScoreCount);
}

     */
    public static void main( String[] args ) {
        solve();
    }
}
