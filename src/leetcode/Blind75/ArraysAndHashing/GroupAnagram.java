package leetcode.Blind75.ArraysAndHashing;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {

        System.out.println(getGroupedAnagram(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public static Collection<List<String>> getGroupedAnagram(String[] input){
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word :
                input) {
            char[] charCount = new char[26];
            for (char c :
                    word.toCharArray()) {
                charCount[c-'a']++;
            }
            String charCountString = new String(charCount);
            anagramMap.computeIfAbsent(charCountString,k -> new ArrayList<String>());
            anagramMap.get(charCountString).add(word);

            anagramMap.get(charCountString).toArray(new String[0]);


        }

        return anagramMap.values();
    }
}
