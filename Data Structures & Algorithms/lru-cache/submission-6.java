class LRUCache {
    int capacity;
    Map<Integer,Node> keyMap=new HashMap<>();
    Node left=new Node(0,0);
    Node right=new Node(0,0);
    
    static class Node{
        Node prev;
        Node next;
        int key;
        int value;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            
        }
    }

    public LRUCache(int capacity) {
        this.capacity=capacity;
        left.next=right;
        right.prev=left;
    }
    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void insert(Node node){
        Node prevRight = right.prev;
        prevRight=right.prev;
        right.prev=node;
        node.prev=prevRight;
        prevRight.next=node;
        node.next=right;

    }
    
    public int get(int key) {
        if(!keyMap.containsKey(key)){
            return -1;
        }
        Node node=keyMap.get(key);
       
        remove(node);
        insert(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(keyMap.containsKey(key)){
            remove(keyMap.get(key));            
        }
        Node node = new Node(key,value);
        keyMap.put(key,node);
        insert(node);  
        if(keyMap.size()>capacity){  
            Node toDelete=keyMap.get(left.next.key);          
            keyMap.remove(left.next.key);   
            remove(toDelete);        
        } 
             
               
    }
}
