package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.HashMap;
import java.util.Stack;

public class FrequencyStack {

    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> m = new HashMap<>();
    private int maxfreq = 0;

    //https://leetcode.com/problems/maximum-frequency-stack/

    //This solution can also implement as TopKFrequentElements
    public static void main( String[] args ) {
        FrequencyStack frequencyStack = new FrequencyStack();

        frequencyStack.push(5);
        frequencyStack.push(7);
        frequencyStack.push(5);
        frequencyStack.push(7);
        frequencyStack.push(4);

        System.out.println(frequencyStack.pop());
    }

    public void push( int x ) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);

        maxfreq = Math.max(maxfreq, f);

        if (!m.containsKey(f))
            m.put(f, new Stack<>());

        //for each frequency we are adding value:
        // f = 2 -> {5,7}
        //f = 1 -> {5,7,4}
        m.get(f).add(x);
    }

    public int pop() {
        int x = m.get(maxfreq).pop();
        freq.put(x, maxfreq - 1);

        if (m.get(maxfreq).size() == 0)
            maxfreq--;

        return x;
    }
}