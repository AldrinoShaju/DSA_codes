package leetcode.Blind75.Greedy;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has
 * the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 */
public class maximumSubarray {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {

        if (nums.length == 1) return nums[0];

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            sum += n;
            max = Math.max(max, sum);

            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
