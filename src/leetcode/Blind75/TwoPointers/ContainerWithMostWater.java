package leetcode.Blind75.TwoPointers;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn
 * such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(getMaxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int getMaxArea(int[] height){
        int max = 0;
        int i = 0;
        int j = height.length-1;

        while(i!=j){
            int area = Math.min(height[i], height[j]) * (j-i);
            max = Math.max(area, max);

            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }

        return max;
    }
}
