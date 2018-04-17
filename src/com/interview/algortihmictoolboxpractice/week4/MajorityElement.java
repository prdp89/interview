package com.interview.algortihmictoolboxpractice.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MajorityElement {


    //This function is not used in this file but, it find Majority element using Moore's algo
    //Ref. : Geeks for Geeks..
    /* Function to find the candidate for Majority */
    int findCandidate(int a[], int size)
    {
        int maj_index = 0, count = 1;
        for (int i = 1; i < size; i++)
        {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0)
            {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    public static void main( String[] args ) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        findMajorityElement(a);
    }

    private static void findMajorityElement( int[] arr ) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int anArr : arr) {
            if (map.containsKey(anArr)) {
                int count = map.get(anArr) + 1;
                if (count > arr.length / 2) {
                    System.out.println("1");
                    // System.out.print("Majority found :- " + arr[i]);
                    return;
                } else
                    map.put(anArr, count);

            } else
                map.put(anArr, 1);
        }
        System.out.println("0");
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
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
