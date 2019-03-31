package com.interview.codingblocks.week10DivideAndConquer;

public class MinElementInSortedRotatedArray {

    //This program is almost same as HighestPivotElement except the returning value:
    //Which should me Minimum.

    //https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/

    public static void main( String[] args ) {

        //int[] a = {6, 7, 1, 2, 3, 4, 5};
        int[] a = {2, 3, 4, 5, 6, 7, 8, 1};

        int n = a.length, start = 0, end = n - 1;

        while (start <= end) {

            if (end < start) {
                System.out.println(a[0]);
                break;
            }

            // If there is only one element left
            if (end == start) {
                System.out.println(a[start]);
                break;
            }

            int mid = (start + end) / 2;

            //if a[] = {5, 6, 7, 8, 2, 3, 4}
            //if a[mid] = 8; if(8> a[mid+1]) then min element is 'mid+1'
            if (mid < end && a[mid] > a[mid + 1]) {

                System.out.println(a[mid + 1]);
                break;

            }
            // //if a[] = {5, 6, 7, 1, 2, 3, 4}
            //if a[mid] = 1; if(8 < a[mid - 1]) then min element is 'mid'
            else if (mid > start && a[mid] < a[mid - 1]) {

                System.out.println(a[mid]);
                break;

            }
            //if left part of array is sorted
            else if (a[end] <= a[mid]) {
                start = mid + 1;
            } else if (a[start] >= a[mid]) {
                end = mid - 1;
            }
        }
    }
}
