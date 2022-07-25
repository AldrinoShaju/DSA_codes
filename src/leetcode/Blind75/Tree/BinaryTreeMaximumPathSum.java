package leetcode.Blind75.Tree;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the
 * sequence has an edge connecting them. A node can only appear in the sequence at most once.
 * Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {

    }

    int[] res = new int[1];
    public int maxPathSum(TreeNode root) {
        res[0] = root.value;
        dfs(root);
        return res[0];
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);

        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        int resMax = leftMax + rightMax + root.value;
        res[0] = Math.max(res[0], resMax);

        return root.value + Math.max(leftMax, rightMax);
    }
}
