package com.interview.codingblocks.week6recursion;

public class CheckArraySortedRecursion {

    private static void solve() {
        int a[] = {1, 2, 3, 5, 7};
       // int a[] = {1, 2, 3, 5, 13, 7};

        System.out.println(checkSortedArray(a, 0));
    }

    private static boolean checkSortedArray( int[] a, int i ) {

        //if index reaches at last element means= array is in sorted order
        if (i == a.length-1)
            return true;


        //check if current element is less than next.
        // 1 2 3 5 7 : check if 1 < 2 in next stack frame checks for..
        // 2 3 5 7 : check if 2 < 3 and so on..
        //If a[i] > a[i+1] then next stack frame won't call and whaterver last frame returns, it will be returned to parent.
        if(a[i] < a[i+1] && checkSortedArray(a, i+1))
            return true;

        return false;
    }

    public static void main( String[] args ) {
        solve();
    }
}
