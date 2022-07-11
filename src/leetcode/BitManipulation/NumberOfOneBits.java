package leetcode.BitManipulation;

/**
 * Write a function that takes an unsigned integer and returns the number
 * of '1' bits it has (also known as the Hamming weight).
 */
public class NumberOfOneBits {

    public static void main(String[] args){
        System.out.println(hammingWeight(4));
    }

        // you need to treat n as an unsigned value
        public static int hammingWeight(int n){
            int count = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                int i1 = n & mask;
                if (i1 != 0) {
                    count++;
                }
                n >>= 1;
            }
            return count;
        }

    public int hammingWeightSmaller(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }


}
