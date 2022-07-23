package leetcode.Blind75.Tree;


/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTree {
    public static void main(String[] args) {

    }

    public static boolean isSame(TreeNode t1, TreeNode t2){

        if(t1 == null && t2 == null){
            return true;
        }else if(t1 == null || t2 == null || t1.value != t2.value){
            return false;
        }
        return isSame(t1.right, t2.right) && isSame(t1.left, t2.left);

    }
}
