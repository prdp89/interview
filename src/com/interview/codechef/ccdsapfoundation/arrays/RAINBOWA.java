package com.interview.codechef.ccdsapfoundation.arrays;

import java.util.Scanner;

public class RAINBOWA {
    //https://www.codechef.com/AUG17/problems/RAINBOWA


    //wrong answer : read this : https://discuss.codechef.com/t/rainbowa-editorial/15912/2
    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();
                int arr[] = new int[n];

                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                }

                if (n % 2 == 0)
                    System.out.println("No");
                else {
                    int i = 0, end = n - 1, mid = n / 2;
                    while (mid-- > 0) {
                        if (arr[i++] != arr[end--]) {
                            break;
                        }
                    }

                    if (mid > 0)
                        System.out.println("No");
                    else
                        System.out.println("Yes");
                }
            }
        } catch (Exception e) {
            return;
        }
    }
}
