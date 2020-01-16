package com.interview.hackerrank.basicPractice;

import java.util.HashSet;
import java.util.Scanner;

public class BeautifulTriplets {

    private static void solve() {
        int d = 3, count = 0;
        int arr[] = {1, 2, 4, 5, 7, 8, 10};

        for (int i = 0; i < arr.length - 3; i++) {

            for (int j = i + 1; j < arr.length - 2; j++) {

                if (arr[j] - arr[i] == d) {
                    for (int k = j + 1; k < arr.length; k++) {

                       /* if (arr[j] - arr[i] == arr[k] - arr[j] && arr[j] - arr[i] == d) {
                            count++;
                        }*/

                        if (arr[k] - arr[j] == d) {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);

    }

    /*
    We are given an increasing input sequence, so no duplicate values exist
    Our HashSet needs to have 3 elements, which we'll call i, j, k, that create a "beautiful triplet"
    as explained in the problem statement. When we come across element "k", we check to see if our HashSet
    also has elements "i" and "j". This is done by noting that we need to have :

    a[i] + 2*d == a[j] + d == a[k]

    to have a beautiful triplet.

    d= 3;
    arr = {{1, 2, 4, 5, 7, 8, 10}}
    one beautiful triplet is : {1 , 4,  7}
    suppose we are at : arr element k = 7 then i = 1 + 2 * 3 [d] = 7 then j = 4 + 3[d] = 7 ; so 7= 7 = 7

    as in below logic if user enters 7 : then we are checking :
    7 - 3[d] = 4 && 7 - 2 * 3 = 1 => {1,4,7} a beautiful triplet

     */
    private static void solveOptimal() {

        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int d = scan.nextInt();

        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int num = scan.nextInt();
            if (set.contains(num - d) && set.contains(num - (2 * d))) {
                count++;
            }
            set.add(num);
        }

        scan.close();
        System.out.println(count);
    }

    //https://www.hackerrank.com/challenges/beautiful-triplets/problem
    public static void main( String[] args ) {
        solve();

        // solveOptimal();
    }
}
