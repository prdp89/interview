package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.HashMap;
import java.util.Stack;

public class FrequencyStack {

    private HashMap<Integer, Integer> freq = new HashMap<>();
    private HashMap<Integer, Stack<Integer>> m = new HashMap<>();
    private int maxFreq = 0;

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

        maxFreq = Math.max(maxFreq, f);

        if (!m.containsKey(f))
            m.put(f, new Stack<>());

        //for each frequency we are adding value:
        // f = 2 -> {5,7}
        //f = 1 -> {5,7,4}
        m.get(f).add(x);
    }

    public int pop() {
        int x = m.get(maxFreq).pop();
        freq.put(x, maxFreq - 1);

        if (m.get(maxFreq).size() == 0)
            maxFreq--;

        return x;
    }
}