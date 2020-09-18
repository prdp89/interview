package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.*;

public class RENT {

    //https://www.spoj.com/problems/RENT/
    public static void main( String[] args ) {
        solveDp();
    }

    private static void solveDp() {
        // try {
        Scanner scanner = new Scanner(System.in);

          /*  int t = scanner.nextInt();

            while (t-- > 0) {
*/
        int n = scanner.nextInt();

        List<Flight> list = new ArrayList<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            Flight flight = new Flight();
            int start = scanner.nextInt();
            flight.startPoint = start;
            flight.endPoint = scanner.nextInt();
            flight.profit = scanner.nextInt();
            list.add(flight);

            arr[i] = start;
        }

        list.sort(Comparator.comparingInt(o -> o.endPoint));

        System.out.println(topDownDp(list, 0, arr) + "  ppp");
        //  }
        /*} catch (Exception e) {
            return;
        }*/
    }

    //not working...........       :((((((((((((
    private static int topDownDp( List<Flight> list, int i, int[] arr ) {
        if (i >= list.size())
            return 0;

        int a = (i >= 0 && i < list.size() - 1 ? list.get(i).profit : 0) +
                topDownDp(list, Arrays.binarySearch(arr, list.get(i).endPoint), arr);

        int b = topDownDp(list, i + 1, arr);

        return Math.max(a, b);
    }

    //result in wrong answer
    private static void solveGreedy() {
        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();

                List<Flight> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    Flight flight = new Flight();
                    flight.startPoint = scanner.nextInt();
                    flight.endPoint = scanner.nextInt();
                    flight.profit = scanner.nextInt();
                    list.add(flight);
                }

                list.sort(Comparator.comparingInt(o -> o.endPoint));

                Flight prev = list.get(0);
                int total = prev.profit;

                for (int i = 1; i < list.size(); i++) {

                    if (list.get(i).startPoint >= prev.endPoint) {
                        total += list.get(i).profit;
                        prev = list.get(i);
                    }

                    if (i <= list.size() - 2 &&
                            list.get(i + 1).startPoint >= prev.startPoint &&
                            list.get(i + 1).profit > list.get(i).profit) {
                        total += list.get(i + 1).profit;
                        total -= prev.profit;
                    }
                }

                System.out.println(total);
            }
        } catch (Exception e) {
            return;
        }
    }

    private static int firstOccurance( int[] a, int n, int key ) {

        int resIndex = -1, start = 0, end = n;

        while (start <= end) {

            int midIndex = (start + end) / 2;

            //little change in this part, bcz we need to search in left part for first occurance
            if (a[midIndex] == key) {
                resIndex = midIndex;
                end = midIndex - 1;
            } else if (a[midIndex] > key) {
                end = midIndex - 1;
            } else
                start = midIndex + 1;
        }
        return resIndex;
    }

    private static class Flight {
        int startPoint;
        int endPoint;
        int profit;
    }
}
