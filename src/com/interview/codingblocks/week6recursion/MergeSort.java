package com.interview.codingblocks.week6recursion;

public class MergeSort {

    //Go through this code:
    //https://gist.github.com/mycodeschool/9678029
    //This video is easy to understand the merge sort algo:
    //https://www.youtube.com/watch?v=TzeBrDU-JaY

    //This code is from Coding Blocks
    //This code uses advance recursion technique. Learn basic from above video.

    private static int count = 0;

    private static void mergeSort( int[] a, int start, int end ) {


        //base case: if final array left with 1 or 0 elements then don't sort.
        if (start >= end)
            return;

        ++count;

        //Follow 3 steps rule :

        //Step 1: Divide
        int mid = (start + end) / 2;

        //Step 2 : Recursively sort the two arrays: Ist array : s -- mid ; IInd array : mid + 1 -- end
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);

        //Step 3 : Merge two arrays parts
        merge(a, start, end);
    }

    public static void main( String[] args ) {

        // int a[] = {3, 11, 1, 0, 5, 2};
        int a[] = {1, 1, 1, 2, 3};

        //if array is already sorted
       /* int i = 1;
        for (; i < a.length; i++) {
            if (a[i] < a[i - 1])
                break;
        }

        if (i == a.length){
            System.out.println("Recursion calls count : "0);
            return;
        }*/

        mergeSort(a, 0, a.length - 1);
        for (int item : a) {

            System.out.print(item + " ");
        }

        System.out.println("Recursion calls count Count : " + count);
    }

    //We merge array using two pointer rule. If first array element is less than second array; Copy Ist array element
    //into temp array and increment ist array pointer. To fill next element increment temp index too.
    private static void merge( int[] a, int s, int e ) {

        int mid = (s + e) / 2;

        int i = s;
        int j = mid + 1;
        int k = s; //to update temp array index

        int temp[] = new int[100];

        while (i <= mid && j <= e) {

            if (a[i] < a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        //if i doesn't reach to the mid
        while (i <= mid) {
            temp[k++] = a[i++];
        }

        //if j doesn't reach to the end
        while (j <= e) {
            temp[k++] = a[j++];
        }

        //copy elements to the original array
        for (int l = s; l <= e; l++)
            a[l] = temp[l];
    }
}
