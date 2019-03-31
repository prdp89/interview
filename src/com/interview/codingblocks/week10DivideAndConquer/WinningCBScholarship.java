package com.interview.codingblocks.week10DivideAndConquer;

import java.util.Scanner;

public class WinningCBScholarship {
    /*
    Prateek Bhaiya decided to give 100% scholarships to the needy students by taking an admission test.
    However in order to avoid any losses at the institute, he came up with a solution.
    Coding Blocks has N students and M discount coupons. A student will get 100% waiver if he gets X discount
    coupons.

    However in order to get more discount coupons in addition to those M , Bhaiya decided that some students who
    perform badly in the admission tests, need to pay additional amount equivalent to Y discount coupons,
    i.e. good students earn discount coupons and weak students need to pay coupons to get admission.

    Find out the maximum number of students who can get 100% waiver in their admission fees.
    Note : Bhaiya will try his best to give 100% dis

    Input Format:
    The first line contains 4 integers N M X Y

    Output Format
    The output should contain a single integer representing the maximum number of students who can get 100% discount.

    Sample Input---
    Test File 1:
    5 10 2 1

    Test File 2:
    3 10 4 2

    Sample Output---
    Output File 1:
    5

    Output File 2:
    2
     */

    //https://www.youtube.com/watch?v=TC6snf6KPdE
    //start video from : 1:20:00
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int start = 0, end = n, ans = 0;
        while (start <= end) {

            int mid = (start + end) / 2;
            if (canSchloarshipBeGranted(mid, x, m, n, y)) {

                start = mid + 1;
                ans = mid;

            } else {
                end = mid - 1;
            }
        }

        System.out.println(ans);

    }

    private static boolean canSchloarshipBeGranted( int mid, int x, int m, int n, int y ) {
        //1 student gets X amount[discount coupon] of scholarship [  ]
        //N students need => N*X = total amount of scholarship [total amount of coupons]

        //M : total discount coupons[amount] available.
        //Y:  additional amount quota available available for each students

        //mid * x : generate total number of coupons possible
        //0 ------------------ N : are total students
        //0---------MID------- N : ( m + ) means we are giving scholarship to 0----MID students
        //0---------MID------- N : (N - MID) means remaining students for scholarship
        //(* Y) means we are trying to get coupons from each students to get max. possible answer

        //0---------MID : returns true then we ignore left boundary and search in MID----------N positions.
        return ((mid * x) <= m + (n - mid) * y);
    }
}
