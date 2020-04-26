package com.interview.leetcode.nickwhite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class TreeMapExample {

    public static void main( String[] args ) {
        TreeSet<Double> treeSet = new TreeSet<>();
        List<Double> list = new ArrayList<>(Arrays.asList(0.0000
                , 0.0169
                , 0.0339
                , 0.0508
                , 0.0678
                , 0.0847
                , 0.1017
                , 0.1186
                , 0.1356
                , 0.1525
                , 0.1695
                , 0.1864
                , 0.2034
                , 0.2203
                , 0.2373
                , 0.2542
                , 0.2712
                , 0.2881
                , 0.3051
                , 0.3220
                , 0.3390
                , 0.3559
                , 0.3729
                , 0.3898
                , 0.4068
                , 0.4237
                , 0.4407
                , 0.4576
                , 0.4746
                , 0.4915
                , 0.5085
                , 0.5254
                , 0.5424
                , 0.5593
                , 0.5763
                , 0.5932
                , 0.6102
                , 0.6271
                , 0.6441
                , 0.6610
                , 0.6780
                , 0.6949
                , 0.7119
                , 0.7288
                , 0.7458
                , 0.7627
                , 0.7797
                , 0.7966
                , 0.8136
                , 0.8305
                , 0.8475
                , 0.8644
                , 0.8814
                , 0.8983
                , 0.9153
                , 0.9322
                , 0.9492
                , 0.9661
                , 0.9831
                , 1.0000
        ));
        treeSet.addAll(list);

        Double marks = 4.0;

        System.out.println("size:" + treeSet.size());
        System.out.println("element diff : " + (treeSet.last() - treeSet.first()) / 59);

        Double diff = 0.0169 - 0.0000;

        Double totalMarks = marks * diff;

        Double ceil = treeSet.ceiling(totalMarks);
        Double floor = treeSet.floor(totalMarks);

        Double val = ceil == null ? Double.MAX_VALUE : (ceil - totalMarks) * 10;
        Double val1 = floor == null ? Double.MAX_VALUE : (totalMarks - floor) * 10;

        System.out.println(Math.min(val, val1));
    }
}
