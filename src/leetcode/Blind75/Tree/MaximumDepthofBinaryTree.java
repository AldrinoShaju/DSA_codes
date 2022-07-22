package leetcode.Blind75.Tree;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along
 * the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthofBinaryTree {

    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
