package leetcode.Blind75.BitManipulation;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = (a ^ b);
            b = tmp;
        }
        return a;
    }
}
