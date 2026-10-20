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

    public ListNode getKth(ListNode curr,int k){
        int nr=0;
        while(nr<k){            
            if(curr==null){
                return null;
            }
            nr++;
            curr=curr.next;
        }
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0,head);
        ListNode groupPrev=dummy;        
        
        while (true) {
        ListNode kth = getKth(groupPrev, k);
        if (kth == null) {
            break;             
        }
        ListNode temp=groupPrev.next;
        ListNode groupNext = kth.next;
        
        ListNode prev=groupNext;
        ListNode curr=groupPrev.next;
        ListNode next=curr.next;
        while(curr != groupNext){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        groupPrev.next=kth;
        groupPrev=temp;
        // PARTEA 3: reconectează și mută groupPrev
        // (două-trei rânduri, vezi indiciul de data trecută)
        }
        return dummy.next;
    }
}


