package com.interview.sapient2019dec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class sample1 {

    public static void main( String[] args ) {

        Integer[] arr = {4, 3, 2, 1};

        System.out.println(maxTrailingAgain(arr));
    }

    private static int maxTrailing( Integer[] arr ) {
        List<Integer> list = Arrays.asList(arr);

        if (list.size() == 1)
            return 1;

        int max = Integer.MIN_VALUE;
        for (int j = 1; j < list.size(); j++) {

            for (int i = 0; i < j; i++) {
                int val = list.get(j) - list.get(i);

                max = Math.max(max, val);
            }

            //max = Math.max(max, count);
        }

        return max == Integer.MIN_VALUE || max == 0 ? -1 : max;
    }


    private static int maxTrailingAgain( Integer[] arr ) {
        List<Integer> list = Arrays.asList(arr);

        if (list.size() == 1)
            return 1;

        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            pairList.add(new Pair(list.get(i), i));
        }

        pairList.sort(Comparator.comparingInt(a -> a.num));

        int max = Integer.MIN_VALUE;

        for (int i = 0, j = list.size() - 1; i < pairList.size(); i++) {

            if (pairList.get(i).index < pairList.get(j).index) {
                max = Math.max(max, pairList.get(j).num - pairList.get(i).num);
                //i++;
            } else {
                //j--;
            }

            i++;
        }

        return max == Integer.MIN_VALUE || max == 0 ? -1 : max;
    }

    static class Pair {
        int num;
        int index;

        Pair( int num, int index ) {
            this.index = index;
            this.num = num;
        }
    }


}
