package com.interview.array;

public class MoveAllZerosToEnd {

    //https://www.geeksforgeeks.org/move-zeroes-end-array/

    public static void main( String args[] ) {
        MoveAllZerosToEnd maz = new MoveAllZerosToEnd();
        int arr[] = {0, 0, 1, 2, 0, 5, 6, 7, 0};
        //maz.moveZeros(arr);

        maz.pushZerosToEnd(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    //Solution from GFG
    // Function which pushes all zeros to end of an array.
    private void pushZerosToEnd( int arr[], int n ) {
        int count = 0;  // Count of non-zero elements

        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i]; // here count is
        // incremented

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < n)
            arr[count++] = 0;
    }


    private void moveZeros( int arr[] ) {
        int slow = 0;
        int fast = 0;
        while (fast < arr.length) {
            if (arr[fast] == 0) {
                fast++;
                continue;
            }
            arr[slow] = arr[fast];
            slow++;
            fast++;
        }
        while (slow < arr.length) {
            arr[slow++] = 0;
        }
    }
}
