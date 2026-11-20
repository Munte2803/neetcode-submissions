class Solution {

    public boolean validTree(int n, int[][] edges) {
       if(edges.length>n-1){
        return false;
       }
       List<List<Integer>> adj= new ArrayList<>();
       for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
       }
       for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            
       }
       Set<Integer> visit = new HashSet<>();

       return dfs(0,-1,n,adj,visit)&&visit.size()==n;

    }
    public boolean dfs(int node, int parent, int n, List<List<Integer>>adj,Set<Integer> visit ){
       
        if(visit.contains(node)){
            return false;
        }
        visit.add(node);
        for(int child: adj.get(node)){
            if(child==parent){
                continue;
            }
            if(!dfs(child, node, n, adj, visit)){
                return false;
            }
        }
        return true;
    }
    
    
}
