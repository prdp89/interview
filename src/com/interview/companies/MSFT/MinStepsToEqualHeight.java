package com.interview.companies.MSFT;

import java.util.*;

public class MinStepsToEqualHeight {

    //https://leetcode.com/discuss/interview-question/364618/

    /*
    Alexa is given n piles of equal or unequal heights. In one step,

    Alexa can remove any number of boxes from the pile which has the maximum height and try to make
    it equal to the one which is just lower than the maximum height of the stack. Determine the minimum
    number of steps required to make all of the piles equal in height.
     */
    public static void main( String[] args ) {
        int[] arr = {5, 2, 1};

        System.out.println(minStepsMaxHeap(arr));
        System.out.println("Tricky:" + stepTricky(new Integer[]{5, 2, 1}));
    }

    private static int minStepsMaxHeap( int[] piles ) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int pile : piles)
            map.put(pile, map.getOrDefault(pile, 0) + 1);

        //sort acc to map frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(( a, b ) -> b.getKey() - a.getKey());
        pq.addAll(map.entrySet());

        int steps = 0;

        while (pq.size() > 1) { //bcz we don't want to remove all elements out of PQ

            //highest frequency
            Map.Entry<Integer, Integer> entry_1 = pq.poll();

            //second highest frequency
            Map.Entry<Integer, Integer> entry_2 = pq.poll();

            //if Alexa remove box of equal height in 1 step, then we get step as occurrance of that height box.
            steps += entry_1.getValue();

            //Now current element removed will be equals to second_highest, so second_highest element Freq. will be:
            //second_element_freq + first_element_frequency

            if (null != entry_2) {
                entry_2.setValue(entry_1.getValue() + entry_2.getValue());
                pq.offer(entry_2);
            }
        }

        return steps;
    }

    //Another tricky implementation..
    private static int stepTricky( Integer[] input ) {
        if (input == null || input.length == 0) {
            return 0;
        }

        int steps = 0;
        Arrays.sort(input, Collections.reverseOrder());

        for (int i = 1; i < input.length; i++) {
            if (input[i] < input[i - 1]) {
                steps += i;
            }
        }
        return steps;
    }
}
