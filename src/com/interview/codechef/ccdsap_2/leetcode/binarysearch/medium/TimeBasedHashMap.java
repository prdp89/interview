package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/time-based-key-value-store/
public class TimeBasedHashMap {

    //TreeMap is same as HashMap instead maintains ascending order(Sorted using the natural order of its key).
    //It cannot have null key but can have multiple null values.
    //TreeMap offers O(log N) lookup and insertion.

    private Map<String, TreeMap<Integer, String>> map;

    /**
     * Initialize your data structure here.
     */
    private TimeBasedHashMap() {
        map = new HashMap<>();
    }

    public static void main( String[] args ) {
        TimeBasedHashMap obj = new TimeBasedHashMap();

        obj.set("key_1", "Hello_1000", 1000);

        String param_2 = obj.get("key_1", 1001); //it returns <= 1001 value

        System.out.println(param_2);
    }

    public void set( String key, String value, int timestamp ) {

        //if map doesn't contain key, add a key then Insert TimeStamp and Value in it.
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }

        map.get(key).put(timestamp, value);
    }

    public String get( String key, int timestamp ) {
        TreeMap<Integer, String> treeMap = map.get(key);

        if (treeMap == null) {
            return "";
        }

        //The floorKey() method is used to return the greatest key less than or equal to given key from the parameter.
        //Example :
        /* Insert the values
        numMap.put(6, "Six");
        numMap.put(1, "One");
        numMap.put(5, "Five");
        numMap.put(3, "Three");
        numMap.put(8, "Eight");
        numMap.put(10, "Ten");*/
        /*
        Get the FloorKey returns:
        System.out.println("Floor Entry of Element 11 is:" + numMap.floorKey(11));
        output:Floor Entry of Element 11 is: 10
         */

        //same as onlineElection in this package
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);

        if(entry == null)
            return "";

        return entry.getValue();
    }
}
