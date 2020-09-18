package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class PIE {

    //https://www.spoj.com/problems/PIE/
    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();
            while (t-- > 0){
                int numOfPies = scanner.nextInt();
                int friends = scanner.nextInt();

                friends++; //one himself

                int[] pieRadius = new int[numOfPies];
                for (int i = 0; i < numOfPies; i++)
                    pieRadius[i] = scanner.nextInt();

                Arrays.sort(pieRadius);

                double[] pieArea = new double[numOfPies];

                for (int i = 0; i < numOfPies; i++) {
                    pieArea[i] = pieRadius[i] * pieRadius[i] * Math.PI;
                }

                System.out.printf("%.4f", binarySearch(pieArea, friends));
                System.out.print("\n");
            }
        } catch (Exception e){
            return;
        }
    }

    private static double binarySearch( double[] pieArea, int friends ) {

        //if friends = 4, area = {26,26,50} then optimal solution = 26+26+50 / 4 = 25.5
        double start = 0.0, end = pieArea[pieArea.length - 1];

        while (end - start > 0.000001) {

            double mid = (start + end) / 2;

            //checking if mid value can distribute between F friends
            if (isFriendsSatify(mid, pieArea, friends) == 1) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private static int isFriendsSatify( double mid, double[] pieArea, int friends ) {
        if (mid == 0)
            return 0;

        int sum = 0;
        for (int i = 0; i < pieArea.length; i++) {
            sum += pieArea[i] / mid; //dividing by mid result in number of person can have that pie share
            //ya fir kitne log (pieArea[i] / mid) ko khaa sakte hai..
        }

        if (sum >= friends)
            return 1;

        return 0;
    }
}
