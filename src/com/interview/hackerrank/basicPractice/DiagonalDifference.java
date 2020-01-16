package com.interview.hackerrank.basicPractice;

import java.io.IOException;
import java.util.Scanner;

public class DiagonalDifference {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the diagonalDifference function below.
    private static int diagonalDifference( int[][] arr ) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    sum1 += arr[i][j];
                }
                if (arr.length - i - 1 == j) {
                    sum2 += arr[i][j];
                }
            }
        }
        return Math.abs(sum1 - sum2);
    }

    public static void main( String[] args ) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = diagonalDifference(arr);

      /*  bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/
        System.out.println(result);
        scanner.close();
    }
}
