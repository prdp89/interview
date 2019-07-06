package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class PartitionKEqualSubsetSum {

    //https://leetcode.com/problems/partition-to-k-equal-sum-subsets
    public static void main( String[] args ) {
        int[] arr = {4, 3, 2, 3, 5, 2, 1};
        int k = 4; //partition into K equal subset with

        System.out.println(canPartitionKSubsets(arr, k));
    }

    private static boolean canPartitionKSubsets( int[] nums, int k ) {
        int sum = 0;

        for (int num : nums)
            sum += num;

        if (k <= 0 || sum % k != 0)
            return false;

        int[] visited = new int[nums.length];

        return canPartition(nums, visited, 0, k, 0, 0, sum / k);
    }

    private static boolean canPartition( int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target ) {

        //if all unique parts contains Sun/K then returns True.
        if (k == 1)
            return true;

        //if First subset matches then check for next subsets decrementing K - 1 and resetting indexes
        if (cur_sum == target && cur_num > 0)
            return canPartition(nums, visited, 0, k - 1, 0, 0, target);

        for (int i = start_index; i < nums.length; i++) {

            //visited : is used bcz if one element is used for subset then it can't be use for another subset
            //This is different from PartitionEqualSubsetSum bcz --
            // there we are partition into two parts and checking if sum/2 exists in {1..N}

            //In this example we are checking sum/K for K subsets. And each array element should be use once in a subset.
            if (visited[i] == 0) {
                visited[i] = 1;

                //similar to PartitionEqualSubsetSum adding current number on cur_num
                if (canPartition(nums, visited, i + 1, k, cur_sum + nums[i], cur_num++, target))
                    return true;

                visited[i] = 0;
            }
        }
        return false;
    }
}
