class WordDictionary {
    
    class TreeNode{
        Map<Character,TreeNode> children=new HashMap<>();
        boolean endOfWord=false;
        public TreeNode(){            
        }
    }

    TreeNode root;

    public WordDictionary() {
        this.root=new TreeNode();
    }

    public void addWord(String word) {
        TreeNode curr=root;
        for(char c: word.toCharArray()){
            curr.children.putIfAbsent(c,new TreeNode());
            curr=curr.children.get(c);            
        }
        curr.endOfWord=true;

    }

    public boolean search(String word) {
    return dfs(root, word, 0);
}

private boolean dfs(TreeNode node, String word, int start) {
    TreeNode curr = node;
    for (int i = start; i < word.length(); i++) {
        char c = word.charAt(i);
        if (c == '.') {
            for (TreeNode child : curr.children.values()) {
                if (dfs(child, word, i + 1)) {
                    return true;              
                }
            }
            return false; 
        } else {
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr=curr.children.get(c);
        }
    }
    return curr.endOfWord;
}
}
