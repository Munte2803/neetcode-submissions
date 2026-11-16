class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> pacific=new HashSet<>();
        Set<List<Integer>> atlantic=new HashSet<>();
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            dfs(i,0,pacific, heights, heights[i][0]);
            dfs(i,heights[i].length-1, atlantic, heights, heights[i][heights[i].length-1]);
        }
        for(int j=0;j<heights[0].length;j++){
            dfs(0,j, pacific, heights,heights[0][j]);
            dfs(heights.length-1,j,atlantic,heights, heights[heights.length-1][j]);
        }  
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[i].length;j++){
                if(pacific.contains(List.of(i,j))&&atlantic.contains(List.of(i,j))){
                    result.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }    
        return result;  
        
    }
    public void dfs(int i, int j, Set<List<Integer>> ocean, int[][] heights, int prev){
        if(i<0||i>=heights.length){
            return;
        }
        if(j<0||j>=heights[i].length){
            return;
        }
        if(heights[i][j]<prev){
            return;
        }
        if(ocean.contains(List.of(i,j))){
            return;
        }
        ocean.add(new ArrayList<>(List.of(i,j)));
        dfs(i+1,j,ocean,heights,heights[i][j]);
        dfs(i-1,j,ocean,heights,heights[i][j]);
        dfs(i,j+1,ocean,heights,heights[i][j]);
        dfs(i,j-1,ocean,heights,heights[i][j]);
    }
    


}
