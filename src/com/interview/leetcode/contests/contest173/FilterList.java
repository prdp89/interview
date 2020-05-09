package com.interview.leetcode.contests.contest173;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterList {

    //https://leetcode.com/contest/weekly-contest-173/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
    public static void main( String[] args ) {
        int veganFriendly = 1, maxPrice = 50, maxDistance = 10;
        int[][] res = new int[][]{
                {1, 4, 1, 40, 10},
                {2, 8, 0, 50, 5},
                {3, 8, 1, 30, 4},
                {4, 10, 0, 10, 3},
                {5, 1, 1, 15, 1}
        };

        filterRestaurants(res, veganFriendly, maxPrice, maxDistance).forEach(System.out::println);
    }

    //31 / 53 test cases passed.
    private static List<Integer> filterRestaurants( int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance ) {

        List<Restrau> list = new ArrayList<>();

        boolean vegan = veganFriendly == 1;

        for (int[] restrau : restaurants) {
            if ((vegan && restrau[2] == veganFriendly)
                    && restrau[3] <= maxPrice
                    && restrau[4] <= maxDistance) {
                list.add(new Restrau(restrau[0], restrau[1]));
            } else if (!vegan) {
                list.add(new Restrau(restrau[0], restrau[1]));
            }
        }

        list.sort(( a, b ) -> a.rating != b.rating ? b.rating - a.rating : b.id - a.id);

        List<Integer> list1 = new ArrayList<>();
        if (list.size() == 0)
            return list1;

        list.forEach(a -> list1.add(a.id));

        return list1;
    }

    public List<Integer> filterRestaurantsOptimal( int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance ) {
        return Arrays.stream(restaurants)
                .filter(s -> s[2] >= veganFriendly && s[3] <= maxPrice && s[4] <= maxDistance)
                .sorted(( a, b ) -> {
                    if (a[1] == b[1])
                        return b[0] - a[0];
                    else
                        return b[1] - a[1];
                })
                .map(i -> i[0])
                .collect(Collectors.toList());
    }

    private static class Restrau {
        //int vegan, maxPrice, maxDist, rating;

        int id, rating;

        Restrau( int id, int rating ) {
            this.id = id;
            this.rating = rating;
        }
    }
}
