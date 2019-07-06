package com.interview.codechef.ccdsap_2.leetcode.arrays.TopKElements;

import java.util.*;

public class TopKFrequentElements {

    //https://leetcode.com/problems/top-k-frequent-elements/#
    public static void main( String[] args ) {

        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;

        //topKFrequent(arr, k).forEach(System.out::println);

        topKFrequentTreeMap(arr, k).forEach(System.out::println);
    }

    //ref: https://leetcode.com/problems/top-k-frequent-elements/discuss/81635/3-Java-Solution-using-Array-MaxHeap-TreeMap
    //-------------Using Bucket Sort----------------------

    private static List<Integer> topKFrequent( int[] nums, int k ) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new List[nums.length + 1];

        //keyset returns the Unique key of hashmap
        for (int n : map.keySet()) {

            int freq = map.get(n);

            if (bucket[freq] == null)
                bucket[freq] = new LinkedList<>();

            //each bucket frequency stores the Number to which frequency belongs.
            bucket[freq].add(n);
        }

        List<Integer> res = new LinkedList<>();

        // use an array to save numbers into different bucket whose index is the frequency
        //iterating from last, since highest feq. element will be at last.
        for (int i = bucket.length - 1; i > 0 && k > 0; --i) {

            if (bucket[i] != null) {

                List<Integer> list = bucket[i];

                res.addAll(list);

                //list.size is always 1; every-time a valid bucket found K value decrements.
                k -= list.size();
            }
        }

        return res;
    }


    //----------------------------------------------------

    //----------------------Using Treemap-----------------

    private static List<Integer> topKFrequentTreeMap( int[] nums, int k ) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        //Tree-map maintain the order of its values
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }

        return res;
    }

    //----------------------------------------------------
}