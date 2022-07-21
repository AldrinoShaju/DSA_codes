package leetcode.Blind75.LinkedList;

import org.w3c.dom.Node;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {
    class ListNode{
        String value;
        ListNode next;
    }


    public static void main(String[] args) {
    }

    public static ListNode reverse(ListNode head){
        ListNode next = null;
        ListNode current = head;

        while(head != null){
            ListNode temp = current.next;
            current.next = next;
            next = current;
            current = temp;
        }

        return next;
    }
}
