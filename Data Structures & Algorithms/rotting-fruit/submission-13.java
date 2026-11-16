class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue=new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int minutes=-1;
        
        while(!queue.isEmpty()){
            int i=0;
            int n=queue.size();
            
            while(i<n){
                int[] linecol=queue.poll();
                int line=linecol[0];
                int col=linecol[1];
                int[][]neighbours={{0,1},{1,0},{-1,0},{0,-1}};
                for(int[] ne:neighbours){
                    int l=line+ne[0];
                    int c=col+ne[1];
                    if(l>=0&&l<grid.length&&c>=0&&c<grid[l].length&&grid[l][c]==1){
                        grid[l][c]=2;
                        queue.add(new int[]{l,c});
                    }
                }
                i++;
                
            }
            minutes++;
            
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        if(minutes==-1){
            return 0;
        }
        return minutes;

        

    }
}
