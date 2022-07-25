package leetcode.Blind75.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
 * to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not
 * necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 */
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {

    }

    private int position;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serDFS(root, list);

        return String.join(",", list);
    }

    public void serDFS(TreeNode root, List<String> list){
        if(root == null){
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.value));
        serDFS(root.left, list);
        serDFS(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return desDFS(values);
    }

    public TreeNode desDFS(String[] values){
        String val = values[this.position];
        if(val.equals("N")){
            this.position++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        this.position++;
        node.left = desDFS(values);
        node.right = desDFS(values);

        return node;
    }

}
