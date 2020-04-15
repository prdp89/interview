package com.interview.codechef.ccdsap_2.leetcode.contests.contest182;

import javafx.util.Pair;

import java.util.HashMap;

public class DesignUndergroundSystem {

    private HashMap<String, Pair<Integer, Integer>> checkoutMap;
    private HashMap<Integer, Pair<String, Integer>> checkInMap;

    private DesignUndergroundSystem() {
        checkInMap = new HashMap<>();  // Uid - {StationName, Time}
        checkoutMap = new HashMap<>(); // Route - {TotalTime, Count}
    }

    //https://leetcode.com/contest/weekly-contest-182/problems/design-underground-system/
    //https://leetcode.com/problems/design-underground-system/discuss/554879/JavaC%2B%2B-HashMap-and-Pair-Clean-code-O(1)
    public static void main( String[] args ) {
        DesignUndergroundSystem undergroundSystem = new DesignUndergroundSystem();

        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);


        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));       // return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
    }

    public void checkIn( int id, String stationName, int t ) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut( int id, String stationName, int t ) {
        Pair<String, Integer> checkIn = checkInMap.get(id);

        String route = checkIn.getKey() + "_" + stationName;

        //time taken to travel between stations by given: ID
        int totalTime = t - checkIn.getValue();

        //finding if More than 2 checkin's previously from same Station..
        Pair<Integer, Integer> checkout = checkoutMap.getOrDefault(route, new Pair<>(0, 0));

        //if some one else also checking from same source station then TotalTime : checkout.getKey() + totalTime
        //and Total count of : checkout.getValue() + 1

        //This helps in storing total checkout for this station..
        checkoutMap.put(route, new Pair<>(checkout.getKey() + totalTime, checkout.getValue() + 1));
    }

    public double getAverageTime( String startStation, String endStation ) {
        String route = startStation + "_" + endStation;

        Pair<Integer, Integer> checkout = checkoutMap.get(route);

        //Average = total time travel DIVIDE by number of person travelled.
        return (double) checkout.getKey() / checkout.getValue();
    }
}
