package leetcode.Blind75.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(getSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> getSum(int[] nums){

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<nums.length-2;i++){
            if(i==0||(nums[i]!=nums[i-1])){
                int target = 0 - nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while (left<right){
                    if(nums[left] + nums[right] == target){
                        List<Integer> miniResult = new ArrayList<>();
                        miniResult.add(nums[i]);
                        miniResult.add(nums[left]);
                        miniResult.add(nums[right]);

                        result.add(miniResult);

                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while (left<right && nums[right]==nums[right-1]){
                            right--;
                        }

                        left++;
                        right--;
                    }else if(nums[left] + nums[right] > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }

        return result;
    }

}
