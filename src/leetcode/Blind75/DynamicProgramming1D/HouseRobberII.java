package leetcode.Blind75.DynamicProgramming1D;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of
 * the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact
 * the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of
 * money you can rob tonight without alerting the police.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int max1 = robHelper(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int max2 = robHelper(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(max1, max2);
    }

    public int robHelper(int[] nums){
        int rob1 = 0, rob2 = 0;

        for(int num: nums){
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
