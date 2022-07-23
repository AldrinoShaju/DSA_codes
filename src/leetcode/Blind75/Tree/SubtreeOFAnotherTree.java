package leetcode.Blind75.Tree;

import com.sun.source.tree.Tree;

/**
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree
 * of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all
 * of this node's descendants. The tree tree could also be considered as a subtree of itself.
 *
 */
public class SubtreeOFAnotherTree {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(sameTree(root, subRoot)){
            return true;
        }else{
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    public boolean sameTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }

        if(root == null || subRoot == null || root.value != subRoot.value){
            return false;
        }

        return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
    }
}
