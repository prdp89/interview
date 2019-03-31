package com.interview.codingblocks.week10DivideAndConquer;

public class InversionCount {

    //https://online.codingblocks.com/player/3880/content/1126?s=1919
    //https://www.geeksforgeeks.org/counting-inversions/
    public static void main( String[] args ) {

        int arr[] = new int[]{3, 2, 1};
        int temp[] = new int[arr.length];

        //(20,6) , (20, 4) , (20, 5) , (6, 4) , (6, 5) => total = 5 inversion
        System.out.println("Number of inversions are :" + _mergeSort(arr, temp, 0, arr.length - 1));
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
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                //This is explained in CodingBlocks as:
                //left[] = {1,2,6} right = {1,1,6}
                //NOw in merging we compare '2' from left with '1' in right
                //'2' in left is greater which means inversion so total inversions will be Sum of element after '2' in left array
                //It is calculated using : mid - i
                inv_count = inv_count + (mid - i);
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
