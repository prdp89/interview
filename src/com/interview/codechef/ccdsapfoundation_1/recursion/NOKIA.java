package com.interview.codechef.ccdsapfoundation_1.recursion;

import java.util.Scanner;

public class NOKIA {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int numOfSolilders = scanner.nextInt();
        int wireLength = scanner.nextInt();

        int max = maxWire(numOfSolilders);
        int min = minWire(numOfSolilders);

        if (wireLength > max) {
            System.out.println(wireLength - max);
        }
        if (wireLength < min) {
            System.out.println("-1");
        }
        if (wireLength <= max && wireLength >= min) {
            System.out.println("0");
        }
    }

    private static int maxWire( int numOfSolilders ) {

        //if last soilder left, then only 2 wire needed to connect left and right
        if (numOfSolilders == 1) {
            return 2;
        }

        //otherwise: one wire extra needed in between each soilder to connect the other
        return (numOfSolilders + 1 + maxWire(numOfSolilders - 1));
    }

    private static int minWire( int numOfSoilders ) {
        //if last soilder left, then only 2 wire needed to connect left and right
        if (numOfSoilders == 1) {
            return 2;
        }

        if (numOfSoilders == 0) {
            return 0;
        }

        //numOfSoilders + 1 + minWire(numOfSoilders / 2) : works as: if n = 2
        // 2+1 = 3 then .. n becomes 1 so for n == 1 we have 2 length wire: Total : 2 + 3 = 5
        // return (numOfSoilders + 1 + minWire(numOfSoilders / 2));

        //For minimum, its always better to try partitioning the problem into two equal subproblems.
        //minLen[n] = (n+1) + minLen[n/2] + minLen[n-1-n/2]

        //so min recurrence is:
        return (numOfSoilders + 1 +
                minWire(numOfSoilders / 2) +
                minWire(numOfSoilders - (numOfSoilders / 2) - 1));
    }
}
