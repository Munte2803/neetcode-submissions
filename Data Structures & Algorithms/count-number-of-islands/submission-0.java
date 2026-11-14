class Solution {
    public int numIslands(char[][] grid) {
        int nr=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    nr++;
                }
            }
        }
        return nr;
    }
    public void dfs(int i,int j,char[][] grid){
        if(i>=grid.length||i<0){
            return;
        }
        if(j>=grid[i].length||j<0){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }else{
            grid[i][j]='0';
            dfs(i+1,j,grid);
            dfs(i-1,j,grid);
            dfs(i,j+1,grid);
            dfs(i,j-1,grid);
        }

    }
}
