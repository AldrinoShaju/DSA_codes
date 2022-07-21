package leetcode.Blind75.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValidUsingStack("()[]{}"));
    }

    public static boolean isValid(String input){
        Stack<Character> pattern = new Stack<>();
        Map<Character, Character> lookupBracket = new HashMap<>(){{
            put('}','{');
            put(']','[');
            put(')','(');
        }};

        for (char c :
                input.toCharArray()) {
            if (lookupBracket.containsKey(c)) {
                if (pattern.peek() == lookupBracket.get(c)) {
                    pattern.pop();
                } else {
                    return false;
                }
            } else {
                pattern.push(c);
            }
        }
        return pattern.isEmpty();
    }

    public static boolean isValidUsingStack(String input){
        Stack<Character> pattern = new Stack<>();

        for (char c :
                input.toCharArray()) {
            switch (c) {
                case '(': pattern.push(')');
                break;
                case '[': pattern.push(']');
                break;
                case '{': pattern.push('}');
                break;
                default: if(pattern.pop()!=c) return false;
                }
            }
        return pattern.isEmpty();
            }



}
