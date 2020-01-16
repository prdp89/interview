package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class MinCostTickets {

    //https://leetcode.com/problems/minimum-cost-for-tickets/
    public static void main( String[] args ) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] cost = {2, 7, 15};

        System.out.println(bottomUpTickets(days, cost));
    }

    //video : https://www.youtube.com/watch?v=Cnf2gdSqjJg
    //ref : https://github.com/Nideesh1/Algo/blob/master/leetcode/L_983.java
    private static int bottomUpTickets( int[] days, int[] cost ) {

        //days : {1, 4, 6, 7, 8, 20}
        //cost : {2, 7, 15}
        //Bottom-up way of thinking :

        //dp[i] indicate cost of travelling on ith day where 'i' denotes the day..
        //1. suppose we have days = {1}
        //   cost of travelling for day 1 = Min{2, 7, 15} => 2
        //   dp[1] = 2

        //2. suppose we have days = {1, 4}
        //   cost of travelling, if we are buying the cost of 1 day ticket = 2 + dp[4 - 1] => 2 +2 => 4
        //   cost of travelling, if we are buying the cost of 7 days ticket = 7 + dp[4 - 7] => 7 + 0 => 7
        //   cost of travelling, if we are buying the cost of 30 days ticket = 15 + dp[4 - 30] => 15 + 0 => 15
        //   so dp[4] = Min {4, 7 , 15} => 4

        //3. Similarly the cost of traveeling on day 6 will be : dp[6] = 2 + dp[6-1] => 2 + 4 => 6

        //4. Now cost of travelling on day 7 will be if days are: {1, 4, 6, 7}
        //   cost of travelling, if we are buying the cost of 1 day ticket = 2 + dp[7 - 1] => 2 + 6 => 8
        //   cost of travelling, if we are buying the cost of 7 days ticket = 7 + dp[7 - 7] => 2 + 0 => 7
        //   cost of travelling, if we are buying the cost of 30 days ticket = 15 + dp[7 - 30] => 15 + 0 => 15
        //    so dp[7] = Min {8, 7 , 15} => 7


        //why n+1 : bcz we have to reach till day
        int n = days[days.length - 1];
        int[] dp = new int[n + 1];

        boolean[] travellingDay = new boolean[n + 1];

        for (int i = 0; i < days.length; i++) {
            int travelling = days[i];
            travellingDay[travelling] = true;
        }

        for (int j = 1; j < dp.length; j++) {

            //if we are not travelling on particular day
            if (travellingDay[j] == false) {
                dp[j] = dp[j - 1];
                continue;
            }

            //trying the possible cost of 3 tickets
            int costOfBuyingOneDayTicket = cost[0] + dp[j - 1];
            int costOfBuyingSevenDaysTicket = cost[1] + dp[Math.max(0, j - 7)];
            int costOfBuyingThirtyDaysTicket = cost[2] + dp[Math.max(0, j - 30)];

            dp[j] = Math.min(costOfBuyingOneDayTicket, Math.min(costOfBuyingSevenDaysTicket, costOfBuyingThirtyDaysTicket));
        }

        return dp[dp.length - 1];
    }
}
