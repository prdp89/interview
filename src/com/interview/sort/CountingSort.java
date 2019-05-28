package com.interview.sort;

public class CountingSort {

    private static int TOTAL = 10;

    public static void main( String args[] ) {
        // int arr[] = {0,3,2,3,3,0,5,2,3};//{ 6, 1, 6, 7, 3, 1 };

        int arr[] = {2, 0, 2, 1, 1, 0};
        CountingSort cs = new CountingSort();
        cs.sort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void sort( int arr[] ) {

        int count[] = new int[TOTAL];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int c = 0;
        for (int i = 0; i < TOTAL; i++) {
            while (count[i] > 0) {
                arr[c++] = i;
                count[i]--;
            }
        }
    }

    public void sort1( int arr[] ) {

        int count[] = new int[TOTAL];
        int output[] = new int[arr.length];

      /*  1) Take a count array to store the count of each unique object.
        Index:     0  1  2  3  4  5  6  7  8  9
        Count:     0  2  2  0   1  1  0  1  0  0*/

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        /*2) Modify the count array such that each element at each index
        stores the sum of previous counts.
        Index:     0  1  2  3  4  5  6  7  8  9
        Count:     0  2  4  4  5  6  6  7  7  7*/

        for (int i = 1; i < TOTAL; i++) {
            count[i] += count[i - 1];
        }

        /*
        Process the input data: 1, 4, 1, 2, 7, 5, 2.
        Position of 1 is 2 in count array.
        Put data 1 at index 2 in output. Decrease count by 1 to place
        next data 1 at an index 1 smaller than this index.
         */
        for (int i = 0; i < arr.length; i++) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
