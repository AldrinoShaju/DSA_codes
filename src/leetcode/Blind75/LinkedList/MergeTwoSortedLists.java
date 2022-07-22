package leetcode.Blind75.LinkedList;

import static leetcode.Blind75.LinkedList.ListNodeUtil.*;
/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = generateSampleLinkedList(5);
        ListNode l2  = generateSampleLinkedList(4);
        printLinkedList(l1);
        printLinkedList(l2);
        printLinkedList(mergeList(l1, l2));
    }

    public static ListNode mergeList(ListNode l1, ListNode l2){
        ListNode result = new ListNode();
        ListNode prev = result;
        while(l1 != null && l2 != null){
            if(l1.value > l2.value){
              prev.next = l2;
              l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;

        }

        if(l1 == null){
            prev.next = l2;
        }else{
            prev.next = l1;
        }

        return result.next;
    }
}
