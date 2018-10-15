package com.interview.codingblocks.week7Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Chopsticks {

    //https://www.codechef.com/problems/TACHSTCK#
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int diff = scanner.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int count=0;
        for (int i=1; i<N; i++){

            if(arr[i] - arr[i -1] >= 0 && arr[i] - arr[i -1] <= diff){
                count++;
                i++;
            }
        }

        System.out.println(count);

    }
}
