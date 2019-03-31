package com.interview.codingblocks.week10DivideAndConquer;

import java.util.Scanner;

class ALPHASCORE {

    //https://www.spoj.com/problems/DCEPC206/
    //help:https://codinghangover.wordpress.com/2014/12/16/spojdcepc206-its-a-murder/
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            int temp[] = new int[arr.length];

            System.out.println(_mergeSort(arr, temp, 0, N - 1));
        }
    }

    /* An auxiliary recursive method that sorts the input array and
      returns the number of inversions in the array. */
    private static int _mergeSort( int arr[], int temp[], int left, int right ) {
        int mid, inv_count = 0;

        if (right > left) {
            /* Divide the array into two parts and call _mergeSortAndCountInv()
           for each of the parts */
            mid = (right + left) / 2;

            /* Inversion count will be sum of inversions in left-part, right-part
                and number of inversions in merging */
            inv_count = _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid + 1, right);

            /*Merge the two parts*/
            inv_count += merge(arr, temp, left, mid + 1, right);
        }
        return inv_count;
    }

    /* This method merges two sorted arrays and returns inversion count in
       the arrays.*/
    private static int merge( int arr[], int temp[], int left, int mid, int right ) {
        int i, j, k;
        int inv_count = 0;

        i = left; /* i is index for left subarray*/
        j = mid; /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right)) {

            //difference from INVCOUNT
            if (arr[i] < arr[j]) {

                 /*
                array = {1, 5, 3, 6, 4}
                left array : {1, 5, 3}
                right arry : {3 , 6, 4}

                Step 1 : 1 * (4 - 0 + 1) => 5
                Step 2 : 5 * (4 - 1 + 1 ) => 10

                total = stp1 + step2 = 15
                 */
                inv_count += arr[i] * (right - j + 1);

                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

               /* //This is explained in CodingBlocks as:
                //left[] = {1,2,6} right = {1,1,6}
                //NOw in merging we compare '2' from left with '1' in right
                //'2' in left is greater which means inversion so total inversions will be Sum of element after '2' in left array
                //It is calculated using : mid - i
                inv_count = inv_count + (mid - i);*/
            }
        }

        /* Copy the remaining elements of left subarray
       (if there are any) to temp*/
        while (i <= mid - 1)
            temp[k++] = arr[i++];

        /* Copy the remaining elements of right subarray
       (if there are any) to temp*/
        while (j <= right)
            temp[k++] = arr[j++];

        /*Copy back the merged elements to original array*/
        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return inv_count;
    }
}