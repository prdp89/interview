package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class SNAKEEAT {

    public static void main( String[] args ) {
        bruteForce();
    }

    //optimal soultion here: https://www.youtube.com/watch?v=I7AgBpTbbTA&feature=youtu.be

    //you got the idea somewhat solved it :)
    private static void bruteForce() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        while (q-- > 0) {
            int[] clone = arr.clone();
            int query = scanner.nextInt();

            Arrays.sort(clone);
            int low = 0, high = arr.length - 1;

            //before starting to find next bigger snake, pls. remove the snake from array which are greater than query
            while (low < high) {

                int mid = (low + high) / 2;
                if (clone[mid] < query && isPossible(clone, mid, query)) {
                    low = mid;
                } else {
                    high = mid;
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (clone[i] >= query)
                    count++;
            }

            System.out.println(count);
        }
    }

    private static boolean isPossible( int[] arr, int mid, int query ) {
        int low = 0, high = mid;
        boolean isTrue = false;

        while (high >= low) {

            if (high > 0 && (arr[high] != -1) && arr[high] < query) {
                arr[high]++;

                if (high < arr.length)
                    arr[high - 1] = -1;

                high -= 2;

                isTrue = true;
            } else {
                low++;
            }
        }

        return isTrue;
    }
}
