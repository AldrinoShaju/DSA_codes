package leetcode.Blind75.BinarySearch;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot
 * index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of
 * target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2,3}, 0));
    }

    public static int search(int[] nums, int target) {
        int minIndex = minIndex(nums);
        int leftSearch = binarySearch(nums, 0, minIndex - 1, target);
        int rightSearch = binarySearch(nums, minIndex, nums.length - 1, target);
        if (leftSearch != -1) {
            return leftSearch;
        } else if (rightSearch != -1) {
            return rightSearch;
        } else {
            return -1;
        }
    }

    public static int minIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid - 1 + nums.length) % nums.length;
            int next = (mid + 1) % nums.length;
            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                return mid;
            } else if (nums[mid] <= nums[end]) {
                end = mid - 1;
            } else if (nums[mid] >= nums[start]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
