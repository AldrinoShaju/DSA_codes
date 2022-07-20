package leetcode.Blind75.SlidingWindow;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        System.out.println(getSubStringCount("abcabcbb"));
    }

    public static int getSubStringCount(String input){
        int maxCount = 0;
        String temp = "";
        for(char c: input.toCharArray()){
            if(temp.contains(String.valueOf(c))){
                temp = temp.substring(temp.indexOf(c)+1);
            }

            temp = temp + c;
            maxCount = Math.max(maxCount, temp.length());
        }

        return maxCount;
    }
}
