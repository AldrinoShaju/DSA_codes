package leetcode.Blind75.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed)
 * of all the values of the nodes in the tree.
 */
public class KthSmallestElementInaBST {
    public static void main(String[] args) {

    }

    public static int kthSmallest(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int popPosition = 0;
        root = root.left;
        while(stack.size() > 0 || root != null){

            while(root!=null){
                stack.push(root);
                root = root.left;
            }

            TreeNode innerRoot = stack.pop();
            popPosition++;
            if(popPosition == k){
                return innerRoot.value;
            }
            root = innerRoot.right;
        }

        return 0;
    }
}
