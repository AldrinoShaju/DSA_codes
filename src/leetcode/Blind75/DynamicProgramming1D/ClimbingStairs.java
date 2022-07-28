package leetcode.Blind75.DynamicProgramming1D;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int a = 0;
        int b = 1;
        int sum = 0;
        while(n!=0){
            sum=a+b;
            a=b;
            b=sum;
            n--;
        }

        return sum;
    }
}
