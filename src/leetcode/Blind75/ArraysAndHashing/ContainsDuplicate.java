package leetcode.Blind75.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at
 * least twice in the array, and return false if every element is distinct.
 */
public class ContainsDuplicate {
    public static void main(String[] args){
        System.out.println(ifDuplicateUsingArray("avc"));
        System.out.println(ifDuplicateUsingArray("coffee"));

    }

    public static boolean ifDuplicateUsingSet(String input){

        if(input==null)
            return false;

        Set<Character> charSet = new HashSet<>();

        for (char inputChar :
                input.toCharArray()) {
            if (!charSet.add(inputChar)){
                return true;
            }
        }

        return false;
    }

    public static boolean ifDuplicateUsingArray(String input){
        if(input==null)
            return false;

        char[] charArray = new char[26];

        for (char inputChar :
                input.toCharArray()) {
            int position = inputChar - 'a';
            charArray[position]++;
            if(charArray[position] > 1){
                return true;
            }
        }

        return false;
    }
}
