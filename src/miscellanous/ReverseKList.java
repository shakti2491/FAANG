package miscellanous;

import utils.ListNode;

public class ReverseKList
{

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head.next.next.next.next = new ListNode(5);
        reverseKGroup(head,3);


    }
    public static ListNode reverseKGroup(ListNode head, int k) {


        ListNode node = head;
        int size = 0;
        while(node!=null){
            node = node.next;
            size++;
        }

        int times = size/k;

        return reverseHelper(head,k,times);

    }


  static   ListNode   reverseHelper(ListNode head, int k, int times){

        if(times == 0)
            return head;

        int K =k;
        ListNode revHead = null;
        ListNode cursor = head;
        ListNode node = head;
        while(k>0){
            node = node.next;
            cursor.next = revHead;
            revHead = cursor;
            cursor = node;
            k--;
        }

        times--;
        node.next = reverseHelper(cursor,K,times);
        return revHead;

    }
}
