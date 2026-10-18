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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode currVal=new ListNode();

        ListNode head=currVal;
        int t=0;       
        
        
            

        while(l1!=null||l2!=null||t!=0){
            ListNode nextVal=new ListNode();
            if(l1==null){
                l1=new ListNode(0);
            }
            if(l2==null){
                l2=new ListNode(0);
            }
            currVal.val=(l1.val+l2.val+t)%10;
            t=(l1.val+l2.val+t)/10;
            
            l1=l1.next;
            l2=l2.next;
            if(l1!=null||l2!=null||t!=0)
                currVal.next=nextVal;
            currVal=currVal.next;                               
        }
        
        
        
        return head;


    }
}
