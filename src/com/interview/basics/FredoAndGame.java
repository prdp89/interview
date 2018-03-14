//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/fredo-and-game/editorial/

package com.interview.basics;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FredoAndGame {

    public void solve() {
        FastReader reader = new FastReader();
        Scanner scanner = new Scanner(System.in);
        int testCases = reader.nextInt();
        while (testCases-- > 0) {
            int ammo = reader.nextInt();
            int obstacles = reader.nextInt();

            // String string[] = reader.readLine().split("\\s+");
            int arr[] = new int[obstacles];
            for (int i = 0; i < obstacles; i++) {
                arr[i] = reader.nextInt();
            }

            int k = 0;
            for (; k < arr.length; k++) {
                ammo = arr[k] == 0 ? ammo - 1 : ammo + 3 - arr[k];
                if (ammo == 0)
                    break;
            }

            Arrays.fill(arr, -1);
            if (k < obstacles - 1)
                System.out.println("No " + (k + 1));
            else
                System.out.println("Yes " + ammo);
        }
    }

    public void correctSolution()
    {
        try (PrintWriter pw = new PrintWriter(System.out, false)) {
            final FastReader sc = new FastReader();
            int t = sc.nextInt();
            int c, n, k;
            int[] a;
            boolean f;
            while (t-- > 0) {
                c = sc.nextInt();
                n = sc.nextInt();
                a = sc.nextArray(n);
                k = 0;
                f = false;
                for (int i = 0; i < n; i++) {
                    if (a[i] == 0) {
                        if (--c == 0 && i != n - 1) {
                            k = i + 1;
                            f = true;
                            break;
                        }
                    } else {
                        c += 2;
                    }
                }
                pw.println(f ? "No " + k : "Yes " + c);
            }
        }
    }

    public static void main( String[] args ) {
        /*FredoAndGame fredoAndGame = new FredoAndGame();
        fredoAndGame.solve();
        fredoAndGame.correctSolution();*/
        System.out.println(10*((10-1)/2));
    }
}
