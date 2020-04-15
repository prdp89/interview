package com.interview.codechef.ccdsap_2.leetcode.design;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//https://leetcode.com/problems/snapshot-array/
public class SnapshotArray {

    private List<TreeMap<Integer, Integer>> arr;
    private int currId = 0;

    private SnapshotArray( int length ) {
        arr = new ArrayList();

        for (int i = 0; i < length; i++) {
            arr.add(i, new TreeMap<Integer, Integer>());
            arr.get(i).put(0, 0);
        }
    }

    //https://leetcode.com/problems/snapshot-array/
    public static void main( String[] args ) {
        SnapshotArray obj = new SnapshotArray(5);
        obj.set(0, 5);

        int param_2 = obj.snap();
        obj.set(0, 6);

        System.out.println(obj.get(0, 0)); //op : 5
    }

    public void set( int index, int val ) {
        arr.get(index).put(currId, val);
    }

    private int snap() {
        return currId++;
    }

    public int get( int index, int snap_id ) {
        return arr.get(index).floorEntry(snap_id).getValue();
    }
}
