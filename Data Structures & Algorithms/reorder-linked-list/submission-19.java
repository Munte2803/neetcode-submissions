/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
       if(head.next==null){
         return;
        } 
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode prevNode=null;
        while(slow.next!=null){
            ListNode nextNode=slow.next.next;
            slow.next.next=prevNode;
            prevNode=slow.next;
            slow.next=nextNode;
        }
        while(prevNode!=null){
            ListNode nextNodeHead=head.next;
            ListNode nextNodeSlow=prevNode.next;
            head.next=prevNode;
            prevNode.next=nextNodeHead;
            head=nextNodeHead;
            prevNode=nextNodeSlow;         

        }
        







    }
}
