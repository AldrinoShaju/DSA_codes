package leetcode.Blind75.DynamicProgramming1D;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
 * space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreak {

    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> workDictSet = new HashSet<>(wordDict);

        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
        }

        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (
                        ((i + word.length()) <= s.length()) &&
                                (s.substring(i, i + word.length()).startsWith(word))
                ) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}
