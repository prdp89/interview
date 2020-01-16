package com.interview.codechef.ccdsap_2.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    //qut : https://leetcode.com/problems/lru-cache/
    //video : https://www.youtube.com/watch?v=S6IfqDXWa10
    //help: https://github.com/bephrem1/backtobackswe/blob/master/Linked%20Lists/LRUCache/LRUCache.java

    //similar qut : https://leetcode.com/problems/design-circular-deque/

    // Hashtable backs up the Doubly Linked List for O(1) access to cache items
    private Map<Integer, ListNode> hashtable = new HashMap<Integer, ListNode>();
    private ListNode head;
    private ListNode tail;
    private int totalItemsInCache;
    private int maxCapacity;

    private LRUCache( int maxCapacity ) {
        // Cache starts empty and capacity is set by client
        totalItemsInCache = 0;
        this.maxCapacity = maxCapacity;

        // Dummy head and tail nodes to avoid empty states
        head = new ListNode();
        tail = new ListNode();

        // Wire the head and tail together
        head.next = tail;
        tail.prev = head;
    }

    public static void main( String[] args ) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);

        System.out.println(lruCache.get(1));

        lruCache.put(3, 3);

        System.out.println(lruCache.get(2));

        lruCache.put(4, 4);

        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }

    public int get( int key ) {
        ListNode node = hashtable.get(key);

        if (node == null) {
            return -1; // we should throw an exception here, but for Leetcode's sake
        }

        // Item has been accessed. Move to the front of the cache
        moveToHead(node);

        return node.value;
    }

    public void put( int key, int value ) {
        ListNode node = hashtable.get(key);

        if (node == null) {
            // Item not found, create a new entry
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;

            // Add to the hashtable and the actual list that represents the cache
            hashtable.put(key, newNode);
            addToFront(newNode);
            totalItemsInCache++;

            // If over capacity remove the LRU item
            if (totalItemsInCache > maxCapacity) {
                removeLRUEntry();
            }
        } else {
            // If item is found in the cache, just update it and move it to the head of the list
            node.value = value;
            moveToHead(node);
        }

    }

    private void removeLRUEntry() {
        ListNode tail = popTail();

        hashtable.remove(tail.key);
        --totalItemsInCache;
    }

    private ListNode popTail() {
        ListNode tailItem = tail.prev;
        removeFromList(tailItem);

        return tailItem;
    }

    private void addToFront( ListNode node ) {
        // Wire up the new node being to be inserted
        node.prev = head;
        node.next = head.next;

    /*
      Re-wire the node after the head. Our node is still sitting "in the middle of nowhere".
      We got the new node pointing to the right things, but we need to fix up the original
      head & head's next.
      head <-> head.next <-> head.next.next <-> head.next.next.next <-> ...
      ^            ^
      |- new node -|
      That's where we are before these next 2 lines.
    */
        head.next.prev = node;
        head.next = node;
    }

    private void removeFromList( ListNode node ) {
        ListNode savedPrev = node.prev;
        ListNode savedNext = node.next;

        savedPrev.next = savedNext;
        savedNext.prev = savedPrev;
    }

    private void moveToHead( ListNode node ) {
        removeFromList(node);
        addToFront(node);
    }

    private class ListNode {
        int key;
        int value;

        ListNode prev;
        ListNode next;
    }
}
