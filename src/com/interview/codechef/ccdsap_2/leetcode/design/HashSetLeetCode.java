package com.interview.codechef.ccdsap_2.leetcode.design;

import java.util.LinkedList;
import java.util.List;

public class HashSetLeetCode {

    //load factor(L) = 10000 / numBuckets = 0.7
    private LinkedList[] lists;
    private int numBuckets = 13000;

    /**
     * Initialize your data structure here.
     */
    private HashSetLeetCode() {
        lists = new LinkedList[numBuckets];
    }

    //qut : https://leetcode.com/problems/design-hashset/
    //ans : https://leetcode.com/problems/design-hashset/discuss/143434/Beats-100-Real-Java-Solution-(Not-boolean-array)
    public static void main( String[] args ) {
        HashSetLeetCode hashMapLeetCode = new HashSetLeetCode();
        hashMapLeetCode.add(1);
        hashMapLeetCode.add(1);

        hashMapLeetCode.add(2);

        System.out.println(hashMapLeetCode.contains(1));
    }

    private int hashing( int key ) {
        return key % numBuckets;
    }

    //time: O(L)
    public void add( int key ) {
        int i = hashing(key);

        if (lists[i] == null)
            lists[i] = new LinkedList<>();

        if (lists[i].indexOf(key) == -1) //we can add bcz we have list of LinkedList array.
            lists[i].add(key);
    }

    //time: O(L)
    public void remove( int key ) {
        int i = hashing(key);

        if (lists[i] == null)
            return;

        if (lists[i].indexOf(key) != -1)
            lists[i].remove(lists[i].indexOf(key));
    }

    //time: O(L)

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains( int key ) {
        int i = hashing(key);

        if (lists[i] == null || lists[i].indexOf(key) == -1)
            return false;
        else
            return true;
    }
}
