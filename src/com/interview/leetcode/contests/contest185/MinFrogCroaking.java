package com.interview.leetcode.contests.contest185;

public class MinFrogCroaking {

    //https://leetcode.com/problems/minimum-number-of-frogs-croaking/

    //based on com.interview.codechef.ccdsap_2.leetcode.arrays.mergeintervals.MettingRoomII
    public static void main( String[] args ) {
        System.out.println(minNumberOfFrogs("croakcroa"));
    }

    /*
    We Will focus here maximum number of On Going Process.
    Once we find one complete "croak" we reudce the OnGoing variable by 1 and once we found a new 'c'
    we will increase the ongoing process.

    We will maintain an array and it will record the count of occurence of each element.
    As any character increases more than it's previous char then it returns -1.
    (Example : "crorak", here when we come to 4th char i.e. to 'r' the count of 'r' become 2 greater then
    'o' which is one so not possible so return -1 here.)
     */
    private static int minNumberOfFrogs( String croakOfFrogs ) {
        int onGoing = 0, maxOnGoing = 0;
        int[] dp = new int[5]; //bcz a frog can only Croack

        for (Character charac : croakOfFrogs.toCharArray()) {

            if (charac == 'c') {
                dp[0]++;
                //1 frog found
                onGoing++;

                maxOnGoing = Math.max(onGoing, maxOnGoing);
            } else {

                if (charac == 'r') {
                    if (dp[0] <= dp[1])
                        return -1;

                    dp[1]++;
                } else if (charac == 'o') {
                    if (dp[1] <= dp[2])
                        return -1;

                    dp[2]++;
                } else if (charac == 'a') {
                    if (dp[2] <= dp[3])
                        return -1;

                    dp[3]++;
                } else if (charac == 'k') {
                    if (dp[3] < dp[4])
                        return -1;

                    dp[4]++;

                    //This checks if Single CROAK is happening or Parallel CROAK is..
                    //If Paraller CROAK voice is there, then multiple Frogs are there..
                    onGoing--;
                }
            }
        }

        //total valid Frog CROAK
        int total = dp[0];
        for (int i = 1; i < 5; i++)
            if (dp[i] != total) //if every character is not having equal frequency..
                return -1;

        return maxOnGoing;
    }
}
