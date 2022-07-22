package leetcode.Blind75.LinkedList;

import static leetcode.Blind75.LinkedList.ListNodeUtil.*;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */

public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        ListNode sample = generateSampleLinkedList(new int[]{1,2,3,4,5});
        printLinkedList(removeNthFromEnd(sample, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start, fast = start;

        for(int i=0;i<n+1;i++){
            fast = fast.next;
        }

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }
}
