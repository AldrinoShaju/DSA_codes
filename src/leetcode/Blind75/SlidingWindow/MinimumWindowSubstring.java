package leetcode.Blind75.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    public static String minWindow(String s, String t){
        Map<Character, Integer> count = new HashMap<>();
        for (char tChar :
                t.toCharArray()) {
            count.put(tChar, count.getOrDefault(tChar, 0)+1);
        }

        int left = 0;
        int minSubStringLength = s.length() + 1;
        int minSubStringStart = 0;
        int have = 0;
        for(int right = 0;right<s.length();right++){
            char sChar = s.charAt(right);
            if(count.containsKey(sChar)){
                count.put(sChar, count.get(sChar) - 1);
                if(count.get(sChar)==0){
                    have++;
                }
            }

            while(have == count.size()){
                if(minSubStringLength>(right- left + 1)){
                    minSubStringLength = right- left + 1;
                    minSubStringStart = left;
                }

                char deleteChar = s.charAt(left++);
                if(count.containsKey(deleteChar)){
                    if(count.get(deleteChar)==0){
                        have--;
                    }
                    count.put(deleteChar, count.get(deleteChar)+1);
                }
            }
        }

        return minSubStringLength > s.length()? "": s.substring(minSubStringStart, minSubStringStart + minSubStringLength);
    }
}
