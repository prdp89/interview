package com.interview.algortihmictoolboxpractice.week1;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct( long[] numbers ) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    static long getMaxPairwiseProductFast( long[] numbers ) {
        int n = numbers.length;

        int maxIndex, maxIndex1;

        maxIndex = maxIndex1 = -1;

        for (int i = 0; i < n; i++) {
            if (maxIndex == -1 || numbers[i] > numbers[maxIndex])
                maxIndex = i;
        }

        for (int i = 0; i < n; i++) {
            if (maxIndex != i && (maxIndex1 == -1 || numbers[i] > numbers[maxIndex1]))
                maxIndex1 = i;
        }

        return numbers[maxIndex] * numbers[maxIndex1];
    }

    public static void main( String[] args ) {
        /*FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));*/

        stressTest();
    }

    private static void stressTest() {
        while (true) {
            Random random = new Random();
            int n =  random.nextInt(10) + 2; // Math.abs(random.nextInt() % 10 + 2); //this generates number in range of 0-10

            long arr[] = new long[n];

            for (int i = 0; i < n; i++)
                arr[i] = (random.nextInt() % 1000); //this generates number in range of 0-1000

            for (int i=0; i< n; i++)
                System.out.print(arr[i] + " ");

            long resultOne = getMaxPairwiseProduct(arr);
            long resultTwo = getMaxPairwiseProductFast(arr);

            if (resultOne != resultTwo)
            {
                System.out.println("\n Wrong Answer " + resultOne + "--" + resultTwo);
                break;
            }
            else
                System.out.println("\n OK " + resultOne + "--" + resultTwo);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner( InputStream stream ) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}