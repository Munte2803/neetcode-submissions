class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] placements=new char[n][n];
        for(char[] ch:placements){
            Arrays.fill(ch,'.');
        }
        List<List<String>> result= new ArrayList<>();
        dfs(0,n,result,placements);
        return result;

    }
    public void dfs(int i, int n, List<List<String>> result, char[][] placements){
        if(i==n){
           List<String> subset=new ArrayList<>(); 
           for(int line=0;line<n;line++){
            subset.add(new String(placements[line]));
           }

           result.add(subset);
           return;
        }
        for(int c=0;c<n;c++){
            if(isSafe(placements,i,c)){
                placements[i][c]='Q';                     
            dfs(i+1,n,result,placements);
            placements[i][c]='.';
            }
            
        }
       

    }
    public boolean isSafe(char[][] placements, int i, int c){
        for(int line=0;line<placements.length;line++){
            for(int col=0;col<placements.length;col++){
                if(placements[line][col]=='Q'&&(line!=i||col!=c)){
                    if(col==c){
                        return false;
                    }
                    if(line-i==col-c||line-i==-(col-c)){
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
