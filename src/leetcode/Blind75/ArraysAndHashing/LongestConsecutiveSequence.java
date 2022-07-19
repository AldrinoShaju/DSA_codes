package leetcode.Blind75.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(getLongestSequence(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    public static int getLongestSequence(int[] input){
        int max = 0;
        int count = 0;

        Set<Integer> intSet = new HashSet<>();
        for(int num:input){
            intSet.add(num);
        }

        for(int num: input){


            if(intSet.contains(num-1)){
                count++;
                intSet.remove(num-1);
            }
            int n =num+1;
            while(intSet.contains(n)){
                count++;
                intSet.remove(n);
                n = n + 1;
            }
        }

        max = Math.max(max, count);
        return max;
    }
}
