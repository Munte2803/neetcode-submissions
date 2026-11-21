class Solution {
    public int countComponents(int n, int[][] edges) {
        int res=n;
        int[] parents= new int[n];

        for(int i=0;i<n;i++){
            parents[i]=i;
        }
    
        for(int[] edge: edges){
            if(union(edge[0],edge[1], parents)){
                res--;
            }
        }
        return res;




        
    }
    public boolean union(int a, int b, int[] parents){
        int x=findX(a, parents);
        int y=findX(b, parents);
        if(x!=y){
            parents[x]=y;
            return true;
        }
        return false;
    }

    public int findX(int i, int[] parents){
        while(parents[i]!=i){
            i=parents[i];
        }
        return i;
    }
    
}
