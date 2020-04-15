package com.interview.codechef.ccdsap_2.leetcode.design;

import java.util.*;

public class InsertDeleteGetRand {

    private Set<Integer> set;
    private List<Integer> list;
    private Random rand;

    public InsertDeleteGetRand() {
        set = new HashSet<>();
        rand = new Random();
        list = new ArrayList<>();
    }

    public static void main( String[] args ) {
        InsertDeleteGetRand randomSet = new InsertDeleteGetRand();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomSet.insert(1);

        // Returns false as 2 does not exist in the set.
        randomSet.remove(2);

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomSet.insert(2);

        // getRandom should return either 1 or 2 randomly.
        System.out.println(randomSet.getRandom());

        // Removes 1 from the set, returns true. Set now contains [2].
        randomSet.remove(1);

        // 2 was already in the set, so return false.
        randomSet.insert(2);

        // Since 2 is the only number in the set, getRandom always return 2.
        System.out.println(randomSet.getRandom());
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert( int val ) {
        if (set.contains(val)) {
            return false;
        } else {
            set.add(val);
            list.add(val);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove( int val ) {
        if (set.contains(val)) {
            list.remove(new Integer(val));
            return set.remove(val);
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
