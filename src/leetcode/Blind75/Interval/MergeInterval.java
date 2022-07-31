package leetcode.Blind75.Interval;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an
 * array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeInterval {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int prevStart = ans.get(ans.size() - 1)[0];
            //comparing the values of prevEnd and curEnd
            int curStart = intervals[i][0];
            if (curStart <= ans.get(ans.size() - 1)[1]) {
                //do the merging
                ans.get(ans.size() - 1)[1] =
                        Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            } else {
                ans.add(intervals[i]);
            }
        }
        int[][] res = new int[ans.size()][2];
        ans.toArray(res);
        return res;
    }
}
