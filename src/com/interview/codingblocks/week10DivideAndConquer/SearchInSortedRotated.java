package com.interview.codingblocks.week10DivideAndConquer;

import java.util.Scanner;

public class SearchInSortedRotated {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = scanner.nextInt();

        int elementToSearch = scanner.nextInt();
        System.out.println(search(arr, 0, arr.length - 1, elementToSearch));
    }

    // Returns index of key in arr[l..h]
    // if key is present, otherwise returns -1
    private static int search( int arr[], int l, int h, int key ) {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;

        /* If arr[l...mid] is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);

            return search(arr, mid + 1, h, key);
        }

        /* If arr[l..mid] is not sorted,
           then arr[mid... r] must be sorted*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);

        return search(arr, l, mid - 1, key);
    }
}
