package leetcode.Blind75.Tree;

import java.util.Arrays;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and
 * inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[0]);
        int mid = 0;
        for(int i = 0;i<preorder.length;i++){
            if(preorder[0] == inorder[i]){
                mid = i;
            }
        }

        newNode.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));

        newNode.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length));

        return newNode;
    }
}
