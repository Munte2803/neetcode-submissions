class Solution {
    public int[] findRedundantConnection(int[][] edges) {
    
        int[] parents= new int[edges.length+1];

        for(int i=0;i<=edges.length;i++){
            parents[i]=i;
        }
    
        for(int[] edge: edges){
            if(!union(edge[0],edge[1], parents)){
                return edge;
            }
        }
        return new int[0];

        




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
