package leetcode.Blind75.BitManipulation;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 */
public class CountingBits {
    public int[] countBits(int n) {

        int[] ans = new int[n+1];

        for(int i = 0; i <= n; i++){
            ans[i] = count(i);
        }
        return ans;
    }

    private int count(int x){
        int count = 0;
        while(x != 0){
            x &= x - 1;
            count++;
        }
        return count;
    }
}
