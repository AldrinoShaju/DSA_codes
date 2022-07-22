package leetcode.Blind75.Tree;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree {
    public static void main(String[] args) {

    }

    public static TreeNode invert(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode right;
        TreeNode left;
        left = invert(root.left);
        right = invert(root.right);

        root.right = left;
        root.left = right;

        return root;
    }
}
