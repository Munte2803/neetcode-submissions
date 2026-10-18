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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nr=0;
        
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode second=dummy;
        ListNode first=dummy;
        
        
        while(nr<n){
            first=first.next;
            nr++;            
        }
        
        while(first.next!=null){
            first=first.next;
            second=second.next;            
        }
        second.next=second.next.next;
        return dummy.next;
        
        

    }
}
