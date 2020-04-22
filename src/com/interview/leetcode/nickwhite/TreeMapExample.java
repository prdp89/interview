package com.interview.leetcode.nickwhite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class TreeMapExample {

    public static void main( String[] args ) {
        TreeSet<Double> treeSet = new TreeSet<>();
        List<Double> list = new ArrayList<>(Arrays.asList(0.0000,
                0.1000,
                0.2000,
                0.3000,
                0.4000,
                0.5000,
                0.6000,
                0.7000,
                0.8000,
                0.9000,
                1.0000
        ));
        treeSet.addAll(list);

        //0.2000
        System.out.println("ceiling :" + treeSet.ceiling(0.1500));

        //0.1000
        System.out.println("floor :" + treeSet.floor(0.1500));
    }
}
