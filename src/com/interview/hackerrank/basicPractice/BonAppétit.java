package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class BonAppétit {

    //https://www.hackerrank.com/challenges/bon-appetit/problem
    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int allegicIndex = scanner.nextInt();

        int arr[] = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }

        int chargedAmount = scanner.nextInt();

        if (allegicIndex >= 0) {
            int excludingDidntEat = sum - arr[allegicIndex];

            if ((excludingDidntEat / 2) == chargedAmount)
                System.out.println("Bon Appetit");
            else
                System.out.println(chargedAmount - (excludingDidntEat / 2));
        }
    }

    public static void main( String[] args ) {
        solve();
    }
}
