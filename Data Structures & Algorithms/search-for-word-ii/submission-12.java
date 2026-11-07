class Solution {

    class TreeNode{
        Map<Character,TreeNode> children=new HashMap<>();
        boolean endOfWord=false;
        public TreeNode(){            
        }
    }
    TreeNode root;
    public void addWord(String word) {
        TreeNode curr=root;
        for(char c: word.toCharArray()){
            curr.children.putIfAbsent(c,new TreeNode());
            curr=curr.children.get(c);            
        }
        curr.endOfWord=true;

    }

    private void dfs(TreeNode node, int i, int j, char[][] board, List<String> words, StringBuilder word) {
        TreeNode curr = node;
        if(i<0||j<0||i>=board.length||j>=board[i].length){
            return;
        }

        if(curr==null){
            return;
        }

        

        if(curr.children.get(board[i][j])!=null){
            word.append(board[i][j]);
            if(curr.children.get(board[i][j]).endOfWord){
                words.add(word.toString());
                curr.children.get(board[i][j]).endOfWord=false;
            } 
            char c=board[i][j];
            board[i][j]='#';
            dfs(curr.children.get(c),i+1,j,board,words,word);
            dfs(curr.children.get(c), i-1,j,board,words,word);
            dfs(curr.children.get(c), i,j+1,board,words,word);
            dfs(curr.children.get(c), i,j-1,board,words,word);
            board[i][j]=c;
            word.deleteCharAt(word.length() - 1);
                     

        }
    }    
    
    public List<String> findWords(char[][] board, String[] words) {
        root=new TreeNode();
        List<String> foundWords=new ArrayList<>();
        
        for(String word:words){
            addWord(word);
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                dfs(root,i,j,board,foundWords,new StringBuilder());
            }
        }

        return foundWords;
    }
}