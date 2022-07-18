package leetcode.Blind75.ArraysAndHashing;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k
 * most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(getKfrequentElements(new int[]{1,1,1,2,2,3}, 2));
    }

    public static int[] getKfrequentElements(int[] input, int k){

            Map<Integer, Integer> freqMap = new HashMap<>();
            List<Integer>[] freqArray = new List[input.length +1];

            for(int num: input){
                if(freqMap.containsKey(num)){
                    freqMap.replace(num, freqMap.get(num) + 1);
                }else{
                    freqMap.put(num, 1);
                }
            }

            for(int key: freqMap.keySet()){
                if(freqArray[freqMap.get(key)]==null){
                    freqArray[freqMap.get(key)] = new ArrayList<>();
                }
                freqArray[freqMap.get(key)].add(key);
            }

            List<Integer> output = new ArrayList<>();

            for(int i = freqArray.length-1;output.size()<k && freqArray.length>0;i--){
                if(freqArray[i]!=null){
                    output.addAll(freqArray[i]);
                }
            }

            return output.stream().mapToInt(Integer::intValue).toArray();



    }
}
