package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

import java.util.TreeMap;

//https://leetcode.com/problems/online-election/
public class OnlineElection {

    //TreeMap stores the Times in ascending order
    //This helps to calculates at What Time which Person Wins
    private TreeMap<Integer, Integer> tm = new TreeMap<>(); // time and leading candidate

    private OnlineElection( int[] persons, int[] times ) {

        int[] count = new int[2]; // count[i]: count of votes for persons[i].

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < times.length; ++i) {

            int personI = persons[i]; //person values are in 0 or 1

            //At each time loop calculating Count of person going for Vote {0 0r 1}
            ++count[persons[i]]; // at times[i], persons[i] got a vote.

            //Max : calculate the last count of person votes {either 0 or 1 is maximum}
            if (max <= count[persons[i]]) { // is persons[i] leading?
                max = count[persons[i]]; // update leading count.

                //so at this Time person I leads.
                tm.put(times[i], persons[i]); // update leading candidate.
            }
        }
    }

    public static void main( String[] args ) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {3, 12, 25, 15, 24, 8};

        OnlineElection obj = new OnlineElection(persons, times);

        int param_1 = obj.q(15); //At time 15 , persons = {0, 1, 1, 0} => tie between 1 & 0
        // but last vote cast to 0 so zero Wins

        System.out.println(param_1);
    }

    public int q( int t ) {
        //The floorKey() method is used to return the greatest key less than or equal to given key from the parameter.
        return tm.floorEntry(t).getValue(); // fetch the corresponding information.
    }
}
