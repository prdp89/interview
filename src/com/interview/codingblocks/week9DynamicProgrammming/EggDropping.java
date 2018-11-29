package com.interview.codingblocks.week9DynamicProgrammming;

public class EggDropping {

    //https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
    //https://online.codingblocks.com/player/3880/content/171?s=1905

    /*
    There are N floors and K eggs. There are some critical floor, if we drop the egg from that floor the eggs breaks.
    We have to Minimize the attempts to find out the critical floor in worst case.
    Attempt : 1 egg dropping consider as an attempt.

    Suppose: There are 5 floors and 1 egg. We'll first try to drop the egg from first floor. If it survives, the drop from 2nd and so on..
             So the min. number of attempts to find out critical floor is 5.


    Recurrence: 1.) If we drop the egg from Xth floor and the Egg breaks after the drop, so we are left with K-1 eggs and X-1 floor
                    THis is equals to f(x-1 floors, k-1 eggs)

                2.) If we drop the egg from Xth floor and the Egg doesn't break, so we are left with K eggs N-X floor.
                    This is equals to f(n-x floors, k eggs)

                So the question ask for worst case, we have to take Math.Max{ 1, 2}

                And for all floor 1..N the question ask Min. the attemps so the final function would be:

                f(n, k) = Math.Min{ for all floor 1..N { Math.Max { 1, 2 } } }
     */
    public static void main( String[] args ) {

    }

    /* Function to get minimum number of trials needed in worst
      case with n eggs and k floors */
    private static int eggDropRecursive( int eggs, int floors ) {
        // If there are no floors, then no trials needed. OR if there is
        // one floor, one trial needed.
        if (floors == 1 || floors == 0)
            return floors;

        // We need k trials for one egg and k floors(we try to drop egg from each floor)
        if (eggs == 1)
            return floors;

        int min = Integer.MAX_VALUE, x, res;

        // Consider all droppings from 1st floor to kth floor and
        // return the minimum of these values plus 1.
        for (x = 1; x <= floors; x++) {

            res = Math.max(eggDropRecursive(eggs - 1, x - 1)
                    , eggDropRecursive(eggs, floors - x));

            if (res < min)
                min = res;
        }

        return min + 1;
    }
}
