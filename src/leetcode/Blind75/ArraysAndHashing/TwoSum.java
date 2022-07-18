package leetcode.Blind75.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(addUsingMap(new int[]{6,2,3,4,5,1}, 10)[1]);
    }

    public static int[] addUsingTwoPointer(int[] input, int target){
        for(int i=1;i<input.length;i++){
            for(int j=i;j<input.length;j++){
                if(target == (input[j] + input[j-i])){
                    return new int[]{j-i, i};
                }
            }
        }

        return new int[]{0};
    }

    public static int[] addUsingMap(int[] input, int target){
        Map<Integer, Integer> valueMap = new HashMap<>();

        for (int i=0;i<input.length;i++) {
            int newTarget = target - input[i];
            if(valueMap.containsKey(newTarget)){
                return new int[]{i, valueMap.get(newTarget)};
            }else{
                valueMap.put(input[i], i);
            }
        }

        return new int[1];
    }
}
