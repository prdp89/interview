package com.interview.codechef.ccdsap_2.leetcode.design;

public class HashMapLeetCode {

    private final ListNode[] nodes = new ListNode[10000];

    //https://leetcode.com/problems/design-hashmap/

    //help : https://leetcode.com/problems/design-hashmap/discuss/152746/Java-Solution
    public static void main( String[] args ) {
        HashMapLeetCode hashMapLeetCode = new HashMapLeetCode();
        hashMapLeetCode.put(1, 1);
        hashMapLeetCode.put(1, 2);

        System.out.println(hashMapLeetCode.get(1));
    }

    //just checking if current node key present in hashmap
    //if present overlap otherwise insert in hashmap.
    public void put( int key, int value ) {
        int i = idx(key);
        if (nodes[i] == null)
            nodes[i] = new ListNode(-1, -1);
        ListNode prev = find(nodes[i], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }

    public int get( int key ) {
        int i = idx(key);
        if (nodes[i] == null)
            return -1;
        ListNode node = find(nodes[i], key);
        return node.next == null ? -1 : node.next.val;
    }

    public void remove( int key ) {
        int i = idx(key);
        if (nodes[i] == null) return;
        ListNode prev = find(nodes[i], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }

    private int idx( int key ) {
        return Integer.hashCode(key) % nodes.length;
    }

    private ListNode find( ListNode bucket, int key ) {
        ListNode node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    class ListNode {
        int key, val;
        ListNode next;

        ListNode( int key, int val ) {
            this.key = key;
            this.val = val;
        }
    }
}
