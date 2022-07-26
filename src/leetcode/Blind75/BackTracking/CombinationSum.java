package leetcode.Blind75.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique
 * combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if
 * the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations
 * for the given input.
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList();
        backtrack(candidates, target, ans, cur, 0);
        return ans;
    }

    public static void backtrack(
            int[] candidates,
            int target,
            List<List<Integer>> ans,
            List<Integer> cur,
            int index
    ) {
        if (target == 0) {
            ans.add(new ArrayList(cur));
        } else if (target < 0 || index >= candidates.length) {
            return;
        } else {
            cur.add(candidates[index]);
            backtrack(candidates, target - candidates[index], ans, cur, index);
//            System.out.println(cur);
            cur.remove(cur.get(cur.size() - 1));
            backtrack(candidates, target, ans, cur, index + 1);
        }
    }
}
