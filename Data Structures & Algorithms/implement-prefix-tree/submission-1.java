class PrefixTree {

    class TreeNode{
        Map<Character,TreeNode> children=new HashMap<>();
        boolean endOfWord=false;
        public TreeNode(){
            
        }

    }

    TreeNode root;

    public PrefixTree() {
        this.root=new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr=root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
               curr.children.put(c,new TreeNode());
            }
            curr=curr.children.get(c);          
            
        }
        curr.endOfWord=true;
    }

    public boolean search(String word) {
        TreeNode curr=root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
               return false;
            }
            curr=curr.children.get(c);
        }

        return curr.endOfWord;

    }

    public boolean startsWith(String prefix) {
        TreeNode curr=root;
        for(char c : prefix.toCharArray()){
            if(!curr.children.containsKey(c)){
               return false;
            }
            curr=curr.children.get(c);
        }

        return true;

    }
}
