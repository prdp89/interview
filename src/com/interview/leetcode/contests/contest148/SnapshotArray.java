package com.interview.leetcode.contests.contest148;

import java.util.HashMap;

public class SnapshotArray {

    //https://leetcode.com/contest/weekly-contest-148/problems/snapshot-array/

    //https://leetcode.com/problems/snapshot-array/discuss/350574/Java-Two-codes-w-analysis-store-difference-by-HashMap-and-TreeMap-respectively.
    //passed : 43 / 71 test cases passed.
    int[] arr = null;
    HashMap<Integer, int[]> map = null;
    int snapId = -1;

    private SnapshotArray( int length ) {
        arr = new int[length];
        map = new HashMap<>();
    }

    public static void main( String[] args ) {
        SnapshotArray snapshotArray = new SnapshotArray(3);

        snapshotArray.set(0, 5);  // Set array[0] = 5
        snapshotArray.snap();  // Take a snapshot, return snap_id = 0
        snapshotArray.set(0, 6);

        System.out.println(snapshotArray.get(0, 0));
    }

    public void set( int index, int val ) {
        arr[index] = val;
    }

    public int snap() {
        map.put(++snapId, arr);

        int len = arr.length;
        arr = new int[len];

        return snapId;
    }

    public int get( int index, int snap_id ) {
        int[] tempArr = map.get(snap_id);
        if (null != tempArr && tempArr.length > 0) {
            return tempArr[index];
        }
        return 0;
    }
}
