package com.interview.codingblocks.week3;

import java.util.Scanner;

//codechef : https://online.codingblocks.com/player/3880/content/58?s=28
// CB : https://hack.codingblocks.com/contests/c/473/838
public class GrayCodeXOR4 {

    /*
    If N >= 130 {1,2,3...130} , we can make 65 pairs : {1,2} {3,4}.. {129, 130} and we have 2^64 means 64 bit number
    Let we calculate XOR of pairs : {1,2} : 0 0 1 ^ 0 1 0 => 0 1 0
                                    {3,4} : 0 1 1 ^ 1 0 0 => 1 0 0
                                    This means if we XOR of two different numbers, we always get 1 set bit at any position.

    We have 64 bit number and 65 pairs for 130 values taken above. So 1 bit have to adjust in any of the 64th bit array.
    So this is an example of PigeonHole principle problem.

    Now Consider we have 64 bit frequency array : { 0 | 0 | 0 | 0 ..... 64}
    From pair {1,2} we got set bit at 1st position, so we set 1st position of 64th bit array : {... | 0 | 0 | 1}
    From pair {3,4} we got set bit at 2nd position, so we set 2nd position of 64th bit array : {... | 0 | 1 | 1}

    Now for remaining : 64 - 2 = 62 pairs position, there must a index of set bit that match with frequency array.
    So, there's always a four distinct indices i1, i2, i3, i4 exist for number greater than or equals 130.

    That's why for number >=130 we don't need to calculate gray code value.

    For less than 130, we can use Brute force approach and submit the answer.

    */
    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        long arr[] = new long[N];

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();

            if (num < 130) {
                arr[i] = num;
            }
        }

        if (N >= 130) {
            System.out.println("YES");
            return;
        }

        //else brute force for smaller values
        for (int i = 0; i < N; i++) {

            for (int j = i + 1; j < N; j++) {

                for (int k = j + 1; k < N; k++) {

                    for (int l = k + 1; l < N; l++) {

                        if ((arr[i] ^ arr[j] ^ arr[k] ^ arr[l]) == 0) {
                            System.out.println("YES");
                            return;
                        }
                    }
                }
            }
        }

        System.out.println("NO");
    }

    public static void main( String[] args ) {
        solve();
    }
}
