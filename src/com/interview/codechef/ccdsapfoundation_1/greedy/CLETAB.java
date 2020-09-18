package com.interview.codechef.ccdsapfoundation_1.greedy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CLETAB {

    //https://www.codechef.com/problems/CLETAB
    public static void main( String[] args ) {
        solve();
    }

    //Wrong answer on it.
    //Read editorial and solve it.
    private static void solve() {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0){
                int tables = scanner.nextInt();
                int orders = scanner.nextInt();

                Set<Integer> set = new HashSet<>();

                int[] arr = new int[orders];
                for (int i = 0; i < orders; i++) {
                    arr[i] = scanner.nextInt(); //order sequence
                }

                int count = 0;
                for (int i = 0; i < orders; i++) {

                    if (!set.contains(arr[i])) {
                        set.add(arr[i]);
                        count++;
                    }
                }

                System.out.println(count);
            }
        } catch (Exception e){
            return;
        }
    }
}
