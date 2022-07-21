package leetcode.Blind75.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k. You can choose any character of the string
 * and change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can
 * get after performing the above operations.
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(getMax("AABABBA", 1));
    }

    public static int getMax(String s, int k){
        Map<Character, Integer> count = new HashMap<>();
        int max = 0;
        int i = 0, j =0;
        int maxCharCount = 0;

        while(j<s.length()){
            count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0)+1);
            maxCharCount = Math.max(maxCharCount, count.get(s.charAt(j)));
            int charToBeReplaced = (j-i+1) - maxCharCount;

            if(charToBeReplaced>k){
                i++;
                count.put(s.charAt(i), count.get(s.charAt(i))-1);
            }

            max = Math.max(max, (j-i+1));
            j++;
        }

        return max;
    }
}
