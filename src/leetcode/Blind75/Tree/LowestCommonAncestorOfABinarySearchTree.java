package leetcode.Blind75.Tree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA)
 * node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both
 * p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.value > root.value && q.value > root.value) return lowestCommonAncestor(
                root.right,
                p,
                q
        );
        if (p.value < root.value && q.value < root.value) return lowestCommonAncestor(
                root.left,
                p,
                q
        );
        return root;
    }

}
