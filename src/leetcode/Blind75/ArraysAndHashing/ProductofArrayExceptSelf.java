package leetcode.Blind75.ArraysAndHashing;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal
 * to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] output = getProductExceptSelf(new int[]{1,2,3,4});
    }

    public static int[] getProduct(int[] nums){
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] result = new int[nums.length];

        prefix[0] = 1;
        postfix[nums.length-1] = nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            prefix[i] = prefix[i-1]*nums[i];
        }

        for(int i=nums.length-2;i>=0;i--){
            postfix[i] = postfix[i+1]*nums[i];
        }

        for(int i=0;i<nums.length;i++){
            int positionLeft = (i-1)<0 ? 1 : (i-1);
            int positionRight = (i+1)>nums.length-1 ? 1 : (i+1);
            result[i] = prefix[positionLeft]*postfix[positionRight];
        }

        return result;
    }

    public static int[] getProductExceptSelf(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
