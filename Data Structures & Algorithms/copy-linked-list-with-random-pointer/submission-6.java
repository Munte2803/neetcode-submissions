/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> nodeMap=new HashMap<>();
        Node dummy=head;
        while(head!=null){
            Node newNode=new Node(head.val);
            nodeMap.put(head,newNode);
            head=head.next;            
        }
        nodeMap.forEach((k, v) -> {
        v.next=nodeMap.getOrDefault(k.next, null);
        v.random=nodeMap.getOrDefault(k.random, null);}
            
            
        );
        return nodeMap.get(dummy);
    }
}
