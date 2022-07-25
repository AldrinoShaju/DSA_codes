package leetcode.Blind75.Trie;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys
 * in a dataset of strings. There are various applications of this data structure, such as autocomplete
 * and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
 * and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the
 * prefix prefix, and false otherwise.
 */
public class ImplementTrie {
    class Node{
        char value;
        boolean isWord;
        Node[] chars;

        Node(char value){
            this.value = value;
            this.isWord = false;
            this.chars = new Node[26];
        }
    }

    Node root;

    public ImplementTrie() {
        root = new Node('\0');
    }

    public void insert(String word) {
        Node curr = root;
        for(char c: word.toCharArray()){
            if(curr.chars[c - 'a'] == null){
                curr.chars[c - 'a'] = new Node(c);
            }

            curr = curr.chars[c - 'a'];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = getLast(word);
        return curr!= null && curr.isWord;
    }

    public Node getLast(String word){
        Node curr = root;
        for(char c: word.toCharArray()){
            if(curr.chars[c - 'a'] == null){
                return null;
            }
            curr = curr.chars[c - 'a'];
        }

        return curr;
    }

    public boolean startsWith(String prefix) {
        Node curr = getLast(prefix);
        return curr != null;
    }
}
