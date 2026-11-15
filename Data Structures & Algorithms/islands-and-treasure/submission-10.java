class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        Queue<int[]> queue=new ArrayDeque<>();       
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            int i=0;
            while(i<queue.size()){
                int[] lc=queue.poll();
                int r=lc[0];
                int c=lc[1];
                int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length
        && grid[nr][nc] == Integer.MAX_VALUE) {
                        grid[nr][nc]=grid[r][c]+1;
                        queue.add(new int[]{nr,nc});    
                    }
                }
                i++;
            

            }
        }
    }
   
}
