package com.interview.codingblocks.week1;

// question: https://www.spoj.com/problems/SUBSUMS/
// Tutorial : https://www.youtube.com/watch?v=ogqFsBE_Qws&t=4560s  ; starts at : 1:17:00
// reference : https://github.com/SharmaManish/Spoj/blob/master/SUBSUMS.cpp

import java.util.*;

public class SubSums {

    private static void solveNow() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int A = scanner.nextInt(); // range a
        int B = scanner.nextInt(); // range b

        int arr[] = new int[N];
        //N array elements, take input in N/2 format

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {

            int sum = 0;
            for (int j = i; j < N; j++) {

                sum += arr[j];

                if (sum >= A && sum <= B) {
                    count++;
                } else if (sum > B) {
                    sum -= arr[j];
                }
            }
        }

        if (A < 0) {
            count += 1;
        }

        System.out.println(count);
    }

    //Problem solved link :  https://hack.codingblocks.com/contests/c/452/136
    private static void solveCodingBlocks() {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        String[] output = new String[testCases];

        for (int j = 0; j < testCases; j++) {

            int N = scanner.nextInt();

            Long[] subSet1 = new Long[N];

            for (int i = 0; i < subSet1.length; i++) {
                subSet1[i] = scanner.nextLong();
            }

           subsets(subSet1);
        }
    }

    //Correct solution for SPOJ
    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int A = scanner.nextInt(); // range a
        int B = scanner.nextInt(); // range b

        //N array elements, take input in N/2 format

        Long[] subSet1 = new Long[N / 2];
        Long[] subSet2 = new Long[(N - N / 2)];

        for (int i = 0; i < subSet1.length; i++) {
            subSet1[i] = scanner.nextLong();
        }

        for (int i = 0; i < subSet2.length; i++) {
            subSet2[i] = scanner.nextLong();
        }

        subSet1 = subsets(subSet1);
        subSet2 = subsets(subSet2);

        Arrays.sort(subSet2);

        long answer = 0;

        for (Long aSubSet1 : subSet1) {

            long start = A - aSubSet1;
            long end = B - aSubSet1;

            int lower_bound = bs_lower_bound(subSet2, subSet2.length, (int) start);
            int upper_bound = bs_upper_bound(subSet2, subSet2.length, (int) end);

            answer += (upper_bound - lower_bound);
        }

        System.out.println(answer);

    }

    private static Long[] subsets( Long[] subSet ) {

        int size = subSet.length; //( end - start) + 1;

        //to generate 2^n combinations..if N=3 the 2^3 = 8 combinations
        int totalLength = 1 << size;
        boolean isFound = false;

        Long[] subSetList = new Long[totalLength];

        for (int i = 0; i < totalLength; i++) {

            int j = 0;
            long sum = 0;

            //We are finding set bits of a number, similar to SubsequenceWithBitmask
            for (int no = i; no > 0; no = no >> 1) {

                //if number bit is set; no = 5 = 1 0 1 then, we sum : subset[0] + subset[2]
                if ((no & 1) != 0) {
                    sum += subSet[j];
                }
                j++;
            }

            /*if(sum == 0)
            {
                isFound = true;
                System.out.println("Yes");
                break;
            }*/

            subSetList[i] = sum;
        }

        /*if(!isFound)
            System.out.println("No");*/

        return subSetList;
    }

    public static void main( String[] args ) {
        //solve();

        solveCodingBlocks();
    }

    static int bs_upper_bound( Long a[], int n, int x ) {
        int l = 0;
        int h = n; // Not n - 1
        while (l < h) {
            int mid = (l + h) / 2;
            if (x >= a[mid]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    static int bs_lower_bound( Long a[], int n, int x ) {
        int l = 0;
        int h = n; // Not n - 1
        while (l < h) {
            int mid = (l + h) / 2;
            if (x <= a[mid]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
