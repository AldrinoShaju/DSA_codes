package leetcode.Blind75.DynamicProgramming1D;

/**
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // Odd Length
            int left = i, right = i;
            while (
                    left >= 0 &&
                            right < s.length() &&
                            s.charAt(left) == s.charAt(right)
            ) {
                result++;
                left--;
                right++;
            }
            // Even Length
            left = i;
            right = i + 1;
            while (
                    left >= 0 &&
                            right < s.length() &&
                            s.charAt(left) == s.charAt(right)
            ) {
                result++;
                left--;
                right++;
            }
        }
        return result;
    }
}
