package com.interview.array;

/**
 * References
 * https://leetcode.com/problems/candy/
 */

//Read from quorA
    /*
From Quora : https://www.quora.com/Dynamic-Programming-DP-How-do-I-solve-Candy-on-LeetCode
 Read Trilok Answer here :

Step 1 : Have the ratings[] array to store 0 to N-1 students ratings.
Step 2 : Have the candies_given[] array to store 0 to N-1 students candies.
Step 3 : Assign candies_given[] array as 1 for all i=0 to N-1. (Minimum candies given should be 1 )
Step 4 : Traverse through ratings array. For every rating check whether current rating is larger than the rating before. if current rating is more, then set candies_given[i] as (candies_given[i-1]+1).
Step 5 : Traverse through ratings array in reverse. For every rating check whether current rating is larger than the rating after. if current rating is more, then check whether candies_given[i] is more than candies_given[i+1], that means it fulfills the condition already due to first traversal(therefore, skip it and move on), but if not, then set candies_given[i] as (candies_given[i+1]+1).
Step 6 : Add all the elements of the candies_given array.

Simple pseudo-code :

--- Step 4 ---
if(rating[i]>rating[i-1])
       candies_given[i]=candies_given[i-1]+1;

--- Step 5 ---
if(rating[i]>rating[i+1])
    if(candies_given[i]<=candies_given[i+1])
          candies_given[i]=candies_given[i+1]+1;

 */

public class LeetCodeCandy {
    public int candy(int[] ratings) {
        int pointOfChange = 0;
        int totalCandies = 1;
        int currentCandy = 1;
        boolean isIndependent = true;
        int maxHeight = 0;
        int diff = 0;
        for (int i = 1; i < ratings.length; i++) {
            diff = 0;
            if (ratings[i] > ratings[i-1]) {
                currentCandy += 1;
            } else if (ratings[i] == ratings[i-1]) {
                isIndependent = true;
                pointOfChange = i;
                currentCandy = 1;
            } else {
                if (currentCandy == 1) {
                    if (!isIndependent) {
                        if (i - pointOfChange == maxHeight - 1) {
                            pointOfChange--;
                        }
                    }
                }
                else {
                    maxHeight = currentCandy;
                    currentCandy = 1;
                    isIndependent = false;
                    pointOfChange = i;
                }
                diff = i - pointOfChange;
            }
            totalCandies += (diff + currentCandy);
        }
        return totalCandies;
    }
}
