/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {     
        Map<Node,Node> map = new HashMap<>();
        dfs(map,node);
        return map.get(node);
        
    }

    public Node dfs(Map<Node,Node> map, Node node){
        if(map.containsKey(node)){
            return map.get(node);
        }
        if(node==null){
            return null;
        }
        
        Node clone=new Node(node.val);
        map.put(node,clone);
        for(Node neighbour:node.neighbors){            
            Node neighbourClone=dfs(map, neighbour);
            clone.neighbors.add(neighbourClone);
            
        }
        
        return clone;
        

    }








}