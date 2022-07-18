package leetcode.Blind75.ArraysAndHashing;

import java.awt.desktop.SystemEventListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagramUsingArray("ar", "ra"));
        System.out.println(isAnagramUsingMap("ar", "ra"));
    }

    public static boolean isAnagramUsingArray(String s, String t){
        char[] sCharArray = new char[26];
        char[] tCharArray = new char[26];

        for (char sChar :
                s.toCharArray()) {
            sCharArray[sChar - 'a']++;
        }

        for (char tChar :
                t.toCharArray()) {
            tCharArray[tChar - 'a']++;
        }

        return Arrays.equals(sCharArray, tCharArray);
    }

    public static boolean isAnagramUsingMap(String s, String t){
        Map<Character, Integer> charMap = new HashMap<>();

        for (char sChar :
                s.toCharArray()) {
            if (charMap.containsKey(sChar)){
                int charValue = charMap.get(sChar);
                charMap.replace(sChar, ++charValue);
            }else{
                charMap.put(sChar, 1);
            }
        }

        for (char tChar :
                t.toCharArray()) {
            if (charMap.containsKey(tChar)){
                int charValue = charMap.get(tChar);
                charMap.replace(tChar, --charValue);
            }else{
                return false;
            }
        }

        for (char cKey :
                charMap.keySet()) {
            if(charMap.get(cKey)!=0){
                return false;
            }
        }

        return true;
    }
}
