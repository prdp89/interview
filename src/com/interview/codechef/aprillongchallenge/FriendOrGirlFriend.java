package com.interview.codechef.aprillongchallenge;

import java.util.Scanner;

public class FriendOrGirlFriend {

    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();

                char[] arr = scanner.next().toCharArray();
                char toFind = scanner.next().toCharArray()[0];

                int total = 0, temp = 0;
                for (int i = 0; i < n; i++) {
                    if (arr[i] == toFind)
                        temp = i + 1;

                    total = total + temp;
                }
                System.out.println(total);
            }
        } catch (Exception e) {
            return;
        }
    }
}
