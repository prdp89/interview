package com.interview.codechef.ccdsapfoundation_1.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CIELRCPT {

    //https://www.codechef.com/problems/CIELRCPT
    public static void main( String[] args ) {
        bruteForce();
        //optimalSolution();
    }

    private static void bruteForce() {
        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();

                Integer[] arr = new Integer[12];
                for (int i = 0; i <= 11; i++) {
                    arr[i] = (int) Math.pow(2, i);
                }

                //instead of sorting we can use hard code array here..
                Arrays.sort(arr, Collections.reverseOrder());

                int sum = 0;
                for (Integer value : arr) {

                    //Eg: n = 255
                    if (n >= value) {

                        sum += n / value;

                        //doing MOD bcz we used 'value' from the 'n'
                        //we are taking remaining value here.
                        n = n % value;
                    }
                }

                System.out.println(sum);
            }
        } catch (Exception e) {
            return;
        }
    }
}
