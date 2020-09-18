package com.interview.codingblocks.week10DivideAndConquer;

public class HighestPivotElement {

    //https://www.youtube.com/watch?v=-MhI4Qtk4KQ
    /*
    Given a sorted and rotated array, Find out the Highest Element(Pivot) in the array using Binary search
    a[] = {5, 6,7, 1, 2 ,3, 4}
    Highest pivot element index is : 2
     */
    public static void main( String[] args ) {

        // int[] a = {6, 7, 1, 2, 3, 4, 5};
        //int[] a = {5, 6, 7, 8, 9, 10, 4};
        //int[] a = {6, 7, 1, 2, 3, 4, 5};
        // int[] a = {4, 5, 1, 2, 3};

        int[] a = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};

        int n = a.length, start = 0, end = n - 1;

        while (start <= end) {

            int mid = (start + end) / 2;
            //if a[] = {5, 6, 7, 8, 2, 3, 4}
            //if a[mid] = 8; if(8> a[mid+1]) then pivot element is 'mid'
            if (mid < end && a[mid] > a[mid + 1]) {

                System.out.println(mid);
                break;

            }
            // //if a[] = {5, 6, 7, 1, 2, 3, 4}
            //if a[mid] = 1; if(8 < a[mid - 1]) then pivot element is 'mid-1'
            else if (mid > start && a[mid] < a[mid - 1]) {

                System.out.println(mid - 1);
                break;

            }
            //if left part of array is sorted
            //a[] = {5, 6, 7, 8, 9, 10, 4} = {5,6,7,8} is sorted
            // if( a[end] <= a[mid]) if(4<=8){ start = mid + 1}
            //we have search in right side of array
            else if (a[end] <= a[mid]) {
                start = mid + 1;
            }
            //if right part of array is sorted
            //a[] = { 6, 7, 1, 2, 3, 4, 5 }
            //midIndex = 3, so left = {6, 7, 1} right = {3, 4, 5}
            //if(a[start] >= a[mid]) if(6 >= 2) end = mid + 1
            //we have to search in left side of array
            else if (a[start] >= a[mid]) {
                end = mid - 1;
            }
        }

        if (start > end)
            System.out.println("Pivot element index does not exist");
    }
}