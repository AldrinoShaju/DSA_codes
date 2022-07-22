package leetcode.Blind75.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static leetcode.Blind75.LinkedList.ListNodeUtil.*;
/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 */

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode sample1 = generateSampleLinkedList(new int[]{1,4,5});
        ListNode sample2 = generateSampleLinkedList(new int[]{1,3,4});
        ListNode sample3 = generateSampleLinkedList(new int[]{2,6});
        printLinkedList(mergeKLists(new ListNode[]{sample1, sample2, sample3}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        List<ListNode> listsC = new ArrayList<>(Arrays.asList(lists));

        while(listsC.size()>1){
            List<ListNode> mergedList = new ArrayList<>();

            for(int i=0;i<listsC.size();i+=2){
                ListNode l1 = listsC.get(i);
                ListNode l2 = i+1>listsC.size() -1?null:listsC.get(i+1);
                mergedList.add(mergeLists(l1, l2));
            }
            listsC = mergedList;
        }

        return listsC.get(0);
    }

    public static ListNode mergeLists(ListNode l1, ListNode l2){

        ListNode result = new ListNode(0);
        ListNode start = result;
        while(l1!=null && l2!=null){
            if(l1.value < l2.value){
                start.next = l1;
                l1 = l1.next;
            }else{
                start.next = l2;
                l2 = l2.next;
            }
            start = start.next;
        }

        start.next = l1==null?l2:l1;

        return result.next;
    }
}
