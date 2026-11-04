class Solution {
    public boolean exist(char[][] board, String word) {
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                if(dfs(0,row,col,board,word,new HashSet<>())){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int i,int row,int col,char[][] board, String word, Set<List<Integer>> visited){
            if(row<0||row>=board.length||col<0||col>=board[0].length){
                
                return false;
            }

            if(board[row][col] != word.charAt(i)){
                
                return false;
            }            
            if(visited.contains(List.of(row,col))){
               
                return false;
            }
            if(i==word.length()-1){
                return true;
            }

            visited.add(List.of(row,col));

            boolean a=dfs(i+1,row+1,col,board,word,visited);
            
            boolean b=dfs(i+1,row-1,col,board,word,visited);
            
            boolean c=dfs(i+1,row,col+1,board,word,visited);
            
            boolean d=dfs(i+1,row,col-1,board,word,visited);

            visited.remove(List.of(row,col));

            return a||b||c||d;

            


            
        }
}

