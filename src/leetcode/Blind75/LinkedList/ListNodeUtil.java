package leetcode.Blind75.LinkedList;

public class ListNodeUtil {

    public static ListNode generateSampleLinkedList(){
        int[] values = new int[]{1,2,3,4,5,6};

        ListNode sample = new ListNode();
        ListNode prev = sample;

        for (int value :
                values) {
            ListNode temp = new ListNode(value);
            prev.next = temp;
            prev = prev.next;
        }

        return sample.next;
    }

    public static ListNode generateSampleLinkedList(int limit){
        ListNode sample = new ListNode();
        ListNode prev = sample;
        int count = 0;
        while(count<=limit) {
            ListNode temp = new ListNode((int) (Math.random() * 10));
            prev.next = temp;
            prev = prev.next;
            count++;
        }

        return sample.next;
    }

    public static ListNode generateSampleLinkedList(int[] values){
        ListNode sample = new ListNode();
        ListNode prev = sample;

        for (int value :
                values) {
            ListNode temp = new ListNode(value);
            prev.next = temp;
            prev = prev.next;
        }

        return sample.next;
    }


    public static void printLinkedList(ListNode head){
        System.out.print("HEAD->");
        while (head!=null){
            System.out.print(head.value);
            head = head.next;
            if(head!=null){
                System.out.print("->");
            }else{
                System.out.println("->NULL");
            }
        }
    }
}
